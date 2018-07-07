package com.saas.commons.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

/**
 * 
 * @ClassName: Thumbnailator
 * @Description: 对图片文件进行压缩,缩放,裁剪,水印等操作
 * @author Orchid
 * @date 2018年2月2日 上午11:09:39
 * @version V3.0
 * 
 */
public class Thumbnailator {

	/**
	 * 指定大小进行缩放
	 * 
	 * @param file
	 *            带转换的文件路径
	 * @param driectFile
	 *            转换后的目的文件路径
	 * @param length
	 *            图片横比
	 * @param height
	 *            图片高
	 * @throws IOException
	 */
	public void size(String file, String driectFile, int length, int height) throws IOException {
		/*
		 * size(width,height) 若图片横比200小，高比300小，不变
		 * 若图片横比200小，高比300大，高缩小到300，图片比例不变 若图片横比200大，高比300小，横缩小到200，图片比例不变
		 * 若图片横比200大，高比300大，图片按比例缩小，横为200或高为300
		 */
		// Thumbnails.of(file).size(200, 300).toFile(driectFile);
		Thumbnails.of(file).size(length, height).toFile(driectFile);
	}

	/**
	 * 图片指定比例缩放与压缩
	 * 
	 * @param file
	 *            带转换的文件路径
	 * @param driectFile
	 *            转换后的目的文件路径
	 * @param scale
	 *            scale是可以指定图片的大小，值在0到1之间，1f就是原图大小，0.5就是原图的一半大小，这里的大小是指图片的长宽。
	 * @param outputQuality
	 *            压缩参数:outputQuality是图片的质量，值也是在0到1，越接近于1质量越好，越接近于0质量越差
	 * @throws IOException
	 */
	public static void scaleAndSize(String file, String driectFile, float scale, float outputQuality) throws IOException {
		Thumbnails.of(file).scale(scale).outputQuality(outputQuality).toFile(driectFile);
	}

	/**
	 * 仅压缩
	 * @param file
	 * @param driectFile
	 * @param outputQuality	压缩参数:outputQuality是图片的质量，值也是在0到1，越接近于1质量越好，越接近于0质量越差
	 * @throws IOException
	 */
	public static void outputQuality(String file, String driectFile, float outputQuality) throws IOException {
		Thumbnails.of(file).outputQuality(outputQuality).toFile(driectFile);
	}
	
	/**
	 * 按照指定比例进行缩放
	 * 
	 * @param file
	 *            带转换的文件路径
	 * @param driectFile
	 *            转换后的目的文件路径
	 * @param scale
	 *            scale是可以指定图片的大小，值在0到1之间，1f就是原图大小，0.5就是原图的一半大小，这里的大小是指图片的长宽。
	 * @throws IOException
	 */
	public void scale(String file, String driectFile, float scale) throws IOException {
		Thumbnails.of(file).scale(scale).toFile(driectFile);
	}

	/**
	 * 不按照比例，指定大小进行缩放
	 * @param file
	 *            带转换的文件路径
	 * @param driectFile
	 *            转换后的目的文件路径
	 * @param length
	 *            图片横比
	 * @param height
	 *            图片高
	 * @param keepAspectRatio	是否按照比例缩放,true:按照比例;false:不按照比例。默认是按照比例缩放的=true
	 * @throws IOException
	 */
	public void sizeWithOutScale(String file, String driectFile, int length, int height,boolean keepAspectRatio) throws IOException {
		Thumbnails.of(file).size(length, height).keepAspectRatio(keepAspectRatio).toFile(driectFile);
	}

	/**
	 * 按照置顶大小缩放旋转
	 * @param file
	 * @param driectFile
	 * @param length
	 * @param height
	 * @param rotate(角度),正数：顺时针 负数：逆时针
	 * @throws IOException
	 */
	public void rotateWithSize(String file, String driectFile, int length, int height,int rotate) throws IOException {
		Thumbnails.of(file).size(length, height).rotate(rotate).toFile(driectFile);
	}

	/**
	 * 仅旋转
	 * @param file
	 * @param driectFile
	 * @param rotate(角度),正数：顺时针 负数：逆时针
	 * @throws IOException
	 */
	public void rotate(String file, String driectFile, int rotate) throws IOException {
		Thumbnails.of(file).rotate(rotate).toFile(driectFile);
	}
	
	/**
	 * 水印
	 * 
	 * @throws IOException
	 */
	public void waterMark() throws IOException {
		/**
		 * watermark(位置，水印图，透明度)
		 */
		Thumbnails.of("images/test.jpg").size(1280, 1024)
				.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("images/watermark.png")), 0.5f)
				.outputQuality(0.8f).toFile("C:/image_watermark_bottom_right.jpg");
		Thumbnails.of("images/test.jpg").size(1280, 1024)
				.watermark(Positions.CENTER, ImageIO.read(new File("images/watermark.png")), 0.5f).outputQuality(0.8f)
				.toFile("C:/image_watermark_center.jpg");
	}

	/**
	 * 裁剪
	 * 
	 * @throws IOException
	 */
	public void test6() throws IOException {
		/**
		 * 图片中心400*400的区域
		 */
		Thumbnails.of("images/test.jpg").sourceRegion(Positions.CENTER, 400, 400).size(200, 200).keepAspectRatio(false)
				.toFile("C:/image_region_center.jpg");
		/**
		 * 图片右下400*400的区域
		 */
		Thumbnails.of("images/test.jpg").sourceRegion(Positions.BOTTOM_RIGHT, 400, 400).size(200, 200)
				.keepAspectRatio(false).toFile("C:/image_region_bootom_right.jpg");
		/**
		 * 指定坐标
		 */
		Thumbnails.of("images/test.jpg").sourceRegion(600, 500, 400, 400).size(200, 200).keepAspectRatio(false)
				.toFile("C:/image_region_coord.jpg");
	}

	/**
	 * 转化图像格式
	 * 
	 * @throws IOException
	 */
	public void test7() throws IOException {
		/**
		 * outputFormat(图像格式)
		 */
		Thumbnails.of("images/test.jpg").size(1280, 1024).outputFormat("png").toFile("C:/image_1280x1024.png");
		Thumbnails.of("images/test.jpg").size(1280, 1024).outputFormat("gif").toFile("C:/image_1280x1024.gif");
	}

	/**
	 * 输出到OutputStream
	 * 
	 * @throws IOException
	 */
	public void test8() throws IOException {
		/**
		 * toOutputStream(流对象)
		 */
		OutputStream os = new FileOutputStream("C:/image_1280x1024_OutputStream.png");
		Thumbnails.of("images/test.jpg").size(1280, 1024).toOutputStream(os);
	}

	/**
	 * 输出到BufferedImage
	 * 
	 * @throws IOException
	 */
	public void test9() throws IOException {
		/**
		 * asBufferedImage() 返回BufferedImage
		 */
		BufferedImage thumbnail = Thumbnails.of("images/test.jpg").size(1280, 1024).asBufferedImage();
		ImageIO.write(thumbnail, "jpg", new File("C:/image_1280x1024_BufferedImage.jpg"));
	}
}