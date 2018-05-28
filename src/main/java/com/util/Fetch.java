package com.util;

import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_highgui;
import org.opencv.core.Core;

/**
 * @Author: YuCheng
 * @Date: 2018/5/28/028 22:52
 * @Description:
 */
public class Fetch {
    public static void main(String[] args) {
        //System.out.println(System.getProperty("java.library.path"));
//       System.out.println("Welcome to OpenCV " + Core.VERSION);
//       System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//       Mat m = Mat.eye(3, 3, CvType.CV_8UC1);
//       System.out.println("m = " + m.dump());

        // 加载本地的OpenCV库，这样就可以用它来调用Java API
       System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Fetch t = new Fetch();
//      t.test();
//      t.run();
//      t.run2();
        t.fetchVideo("D:\\FFOutPut\\8-5_HN1--1070599681_01.mp4","D:/loljpg/m1/");
//      System.out.println(t.CmpPic("d:/img/219.jpg"));
    }
    public void fetchVideo(String targerFile,String savePath) {
        opencv_highgui.CvCapture capture = opencv_highgui.cvCreateFileCapture(targerFile);

        //帧率
        int fps = (int) opencv_highgui.cvGetCaptureProperty(capture, opencv_highgui.CV_CAP_PROP_FPS);
        System.out.println("帧率:"+fps);

        opencv_core.IplImage frame = null;
        double pos1 = 0;

        int rootCount = 0;

        while (true) {

            //读取关键帧
            frame = opencv_highgui.cvQueryFrame(capture);

            rootCount = fps;
            while(rootCount > 0 ){
                //这一段的目的是跳过每一秒钟的帧数,也就是说fps是帧率(一秒钟有多少帧),在读取一帧后,跳过fps数量的帧就相当于跳过了1秒钟。
                frame = opencv_highgui.cvQueryFrame(capture);
                rootCount--;
            }

            //获取当前帧的位置
            pos1 = opencv_highgui.cvGetCaptureProperty(capture,opencv_highgui.CV_CAP_PROP_POS_FRAMES);
            System.out.println(pos1);

            if (null == frame)
                break;

            opencv_highgui.cvSaveImage(savePath + pos1 + ".jpg",frame);

        }

        opencv_highgui.cvReleaseCapture(capture);
    }
}
