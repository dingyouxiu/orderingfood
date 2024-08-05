package com.dyx.ordering.common.utils;

import org.apache.commons.lang3.StringUtils;

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.Sides;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

/**
 * TODO 提供打印服务，还未测试
 */
public class PrintUtil implements Printable {

    private String text;

    public PrintUtil(String text) {
        this.text = text;
    }

    public static void printText(String text) throws PrintException {
        // 查找所有可用的打印服务
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);

        if (printServices.length == 0) {
            System.out.println("No printers available.");
            return;
        }

        // 使用打印服务选择对话框让用户选择打印机
        PrintService printService = ServiceUI.printDialog(null, 200, 200, printServices, printServices[0], null, null);

        if (printService == null) {
            System.out.println("No printer selected.");
            return;
        }

        System.out.println("Printing to: " + printService.getName());

        // 创建打印请求属性集
        PrintRequestAttributeSet attributes = new HashPrintRequestAttributeSet();
        attributes.add(new Copies(1));  // 设置打印份数
        attributes.add(MediaSizeName.ISO_A4);  // 设置纸张大小
        attributes.add(Sides.ONE_SIDED);  // 设置单面打印

        // 创建打印作业
        DocPrintJob printJob = printService.createPrintJob();
        printJob.print(new SimpleDoc(new PrintUtil(text), DocFlavor.SERVICE_FORMATTED.PRINTABLE, null), attributes);
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        Graphics2D graphics2D = (Graphics2D) graphics;
        // 获取初始坐标
        graphics2D.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        // 设置字体格式
        Font font = new Font("Serif", Font.PLAIN, 12);
        graphics2D.setFont(font);

        // 行高、页高、页宽
        int lineHeight = graphics2D.getFontMetrics().getHeight();
        double pageWidth = pageFormat.getImageableWidth();
        double pageHeight = pageFormat.getImageableHeight();

        // 根据内容中的换行符截取打印内容
        String[] lines = text.split("\n");
        int y = 0;
        int currentPage = 0;
        int lineIndex = 0;

        // 跳过前面的页面
        while (currentPage < pageIndex) {
            while (lineIndex < lines.length) {
                String line = lines[lineIndex];
                while (StringUtils.isNotBlank(line)) {
                    int lineLength = fitLineToWidth(line, graphics2D, pageWidth);
                    line = line.substring(lineLength);
                    y += lineHeight;
                    if (y > pageHeight) {
                        y = 0; // 重置y坐标，开始新的一页
                        currentPage++;
                        break;
                    }
                }
                if (currentPage > pageIndex) {
                    break;
                }
                lineIndex++;
            }
            if (lineIndex >= lines.length) {
                return NO_SUCH_PAGE;
            }
        }

        // 开始绘制当前页面的内容
        y = 0;
        while (lineIndex < lines.length) {
            String line = lines[lineIndex];
            while (StringUtils.isNotBlank(line)) {
                int lineLength = fitLineToWidth(line, graphics2D, pageWidth);
                graphics2D.drawString(line.substring(0, lineLength), 0, y);
                line = line.substring(lineLength);
                y += lineHeight;
                if (y > pageHeight) {
                    return PAGE_EXISTS; // 下一页继续打印
                }
            }
            lineIndex++;
        }

        return PAGE_EXISTS; // 当前页打印完，继续打印
    }


    private int fitLineToWidth(String line, Graphics2D graphics2D, double width) {
        int lineLength = line.length();
        while (lineLength > 0 && graphics2D.getFontMetrics().stringWidth(line.substring(0, lineLength)) > width) {
            lineLength--;
        }
        return lineLength;
    }
}
