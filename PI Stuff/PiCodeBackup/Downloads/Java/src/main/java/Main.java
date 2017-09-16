import java.util.ArrayList;

import edu.wpi.first.wpilibj.networktables.*;
import edu.wpi.first.wpilibj.tables.*;
import edu.wpi.cscore.*;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class Main {
  public static void main(String[] args) {
    // Loads our OpenCV library. This MUST be included
    System.loadLibrary("opencv_java310");

    // Connect NetworkTables, and get access to the publishing table
    NetworkTable.setClientMode();
    // Set your team number here
    NetworkTable.setTeam(1495);

    NetworkTable.initialize();


    // This is the network port you want to stream the raw received image to
    // By rules, this has to be between 1180 and 1190, so 1185 is a good choice

    // This stores our reference to our mjpeg server for streaming the input image
    MjpegServer inputStream = new MjpegServer("MJPEG Server", 1185);
    MjpegServer inputStream1 = new MjpegServer("MJPEG Server1",1187);

    // Selecting a Camera
    // Uncomment one of the 2 following camera options
    // The top one receives a stream from another device, and performs operations based on that
    // On windows, this one must be used since USB is not supported
    // The bottom one opens a USB camera, and performs operations on that, along with streaming
    // the input image so other devices can see it.
    
    // HTTP Camera
    /*
    // This is our camera name from the robot. this can be set in your robot code with the following command
    // CameraServer.getInstance().startAutomaticCapture("YourCameraNameHere");
    // "USB Camera 0" is the default if no string is specified
    String cameraName2 = "HTTP Camera 2";
    HttpCamera camera2 = setHttpCamera(cameraName2, "");
    // It is possible for the camera to be null. If it is, that means no camera could
    // be found using NetworkTables to connect to. Create an HttpCamera by giving a specified stream
    // Note if this happens, no restream will be created
   
    if (camera2 == null) {
      camera2 = new HttpCamera("CoprocessorCamera 2", "http://10.14.95.3/?action=stream");
      inputStream2.setSource(camera2);
    }
     
  camera2.setPixelFormat(VideoMode.PixelFormat.kMJPEG);
    
     */

    /***********************************************/

    // USB Camera
    //This is a comment.
    // This gets the image from a USB camera 
    // Usually this will be on device 0, but there are other overloads
    // that can be used
    UsbCamera camera = setUsbCamera(0, inputStream);
    UsbCamera camera1 = setUsbCamera(1, inputStream1);
    // Set the resolution for our camera, since this is over USB
    //camera.setResolution(320,160);
    //camera.setFPS(20);
    camera.setFPS(15);
    camera1.setFPS(15);
    camera.setPixelFormat(VideoMode.PixelFormat.kMJPEG);
    camera1.setPixelFormat(VideoMode.PixelFormat.kMJPEG);
    camera1.setResolution(320,160);
    camera.setResolution(320,160);
    camera.setBrightness(1);

    

    // This creates a CvSink for us to use. This grabs images from our selected camera, 
    // and will allow us to use those images in opencv
    CvSink imageSink = new CvSink("CV Image Grabber");
    CvSink imageSink1 = new CvSink("CV Image Grabber1");
    //CvSink imageSink2 = new CvSink("CV Image Grabber2");
    imageSink.setSource(camera); imageSink1.setSource(camera1); //imageSink2.setSource(camera2);

    // This creates a CvSource to use. This will take in a Mat image that has had OpenCV operations
    // operations 
    //CvSource imageSource = new CvSource("CV Image Source", VideoMode.PixelFormat.kMJPEG, 640, 480, 15);
    //CvSource imageSource1 = new CvSource("CV Image Source1", VideoMode.PixelFormat.kMJPEG,640,480, 15);
   // CvSource imageSource2 = new CvSource("CV Image Source2", VideoMode.PixelFormat.kMJPEG,320,160,15);
    MjpegServer cvStream = new MjpegServer("CV Image Stream", 1186);
    MjpegServer cvStream1 = new MjpegServer("CV Image Stream1", 1188);
    //MjpegServer cvStream2 = new MjpegServer("CV Image Stream2",1190);
    cvStream.setSource(camera); cvStream1.setSource(camera1); //cvStream2.setSource(camera2);

    // All Mats and Lists should be stored outside the loop to avoid allocations
    // as they are expensive to create
    Mat inputImage = new Mat();
    Mat hsv = new Mat();
    //Mat mat = new Mat();
    //Mat mat2 = new Mat();

    // Infinitely process image
    while (true) {
      // Grab a frame. If it has a frame time of 0, there was an error.
      // Just skip and continue
      long frameTime = imageSink.grabFrame(inputImage);
     // long frameTime1 = imageSink1.grabFrame(mat);
      //long frameTime2 = imageSink2.grabFrame(mat2);
      if (frameTime == 0) continue;

      // Below is where you would do your OpenCV operations on the provided image
      // The sample below just changes color source to HSV
      Imgproc.cvtColor(inputImage, hsv, Imgproc.COLOR_BGR2HSV);

      // Here is where you would write a processed image that you want to restreams
      // This will most likely be a marked up image of what the camera sees
      // For now, we are just going to stream the HSV image
     // imageSource1.putFrame(mat);
      // imageSource.putFrame(hsv);
      //imageSource2.putFrame(mat2);
    }
  }

  private static HttpCamera setHttpCamera(String cameraName, MjpegServer server) {
    // Start by grabbing the camera from NetworkTables
    NetworkTable publishingTable = NetworkTable.getTable("CameraPublisher");
    // Wait for robot to connect. Allow this to be attempted indefinitely
    System.out.println("Got Here");
    /*
    while (true) {
      try {
        if (publishingTable.getSubTables().size() > 0) {
          break;
        }
        Thread.sleep(500);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
     */
    System.out.println("Got here now!");
    HttpCamera camera2 = null;
    if (!publishingTable.containsSubTable(cameraName)) {
      return null;
    }
    ITable cameraTable = publishingTable.getSubTable(cameraName);
    String[] urls = cameraTable.getStringArray("streams", null);
    if (urls == null) {
      return null;
    }
    ArrayList<String> fixedUrls = new ArrayList<String>();
    for (String url : urls) {
      if (url.startsWith("mjpg")) {
        fixedUrls.add(url.split(":", 2)[1]);
      }
    }
   // System.out.println(fixedUrls[0]);
   // String thing[] = camera2.getUrls;
    camera2 = new HttpCamera("CoprocessorCamera 2", fixedUrls.toArray(new String[0]));
    server.setSource(camera2);
  // System.out.println(thing);

    return camera2;
  }

  private static UsbCamera setUsbCamera(int cameraId, MjpegServer server) {
    // This gets the image from a USB camera 
    // Usually this will be on device 0, but there are other overloads
    // that can be used
    String name = "Coprocessor Camera: " + cameraId;
    UsbCamera camera = new UsbCamera(name, cameraId);
    server.setSource(camera);
    return camera;
  }
}