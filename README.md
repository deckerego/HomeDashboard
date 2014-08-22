GarageSecurity
==============

A web interface for remote residential garage surveillance. This uses a Raspberry Pi to connect to a universal garage door opener via GPIO and a webcam or Raspberry NoIR video camera.

Hardware Punch List
-------------------

<table>
  <tr>
    <td>Raspberry Pi Model B</td>
    <td>https://www.sparkfun.com/products/11546</td>
  </tr>
  <tr>
    <td>Any Video4Linux-compliant Webcam</td>
    <td>https://www.sparkfun.com/products/12654 (when used with V4L2)</td>
  </tr>
  <tr>
    <td>Chamberlain Universal Garage Remote</td>
    <td>http://www.chamberlain.com/clicker-and-accessories/universal-clicker-products/clicker-universal-remote-control</td>
  </tr>
  <tr>
    <td>Resistors, NPN transistors, NPN MOSFET</td>
    <td>Available at Sparkfun, Adafruit, Radio Shack or from de-soldering unused electronics.</td>
  </tr>
</table>

Hardware Installation
---------------------

See http://hackaday.io/project/2049/instructions for hardware installation

Software Installation
---------------------

This routine will become more streamlined as I move these steps into Debian package dependencies and post-install scripts. Until then:

If you are using the Raspberry Pi camera module, ensure you have also enabled Video4Linux support as documented in http://www.linux-projects.org/modules/sections/index.php?op=viewarticle&artid=16

1. Install Sun's Java Development Kit for ARM
    1. Obtain the tarball from http://www.oracle.com/technetwork/java/javase/downloads/index.html
    2. Unzip the archive into /usr/local
    3. Update the "alternatives" configs using:
        * sudo update-alternatives --install /usr/bin/java java /usr/local/jdk1.8.0_06/bin/java 1
        * sudo update-alternatives --install /usr/bin/javac javac /usr/local/jdk1.8.0_06/bin/javac 1
    4. Select the correct runtime executable using: sudo update-alternatives --config java
    5. Select the correct compiler using: sudo update-alternatives --config javac
    6. Ensure the correct JVM is selected using: java -version
2. Install the GarageSecurity Debian package: sudo dpkg -i ~/GarageSecurity_3.0_all.deb
3. Edit /etc/garagesecurity/application.conf to match your own environment
4. Install and configure Motion
    1. Install in Raspian using: sudo apt-get install motion
    2. Review the samples within GitHub or source packages within /usr/share/garagesecurity/conf/etc/motion for expected config values
5. Install Apache2
    1. Install in Raspian using: sudo apt-get install apache2 libapache2-mod-proxy-html libapache2-mod-authnz-external
    2. Enable the necessary modules using: sudo a2enmod proxy proxy_html authnz_external 
    3. Copy the site "security" from /usr/share/garagesecurity/conf/etc/apache2/sites-available/security into /etc/apache2/sites-available
    4. Replace the default Apache site with GarageSecurity: sudo a2dissite default; sudo a2ensite security
    5. Re-start Apache2: sudo apachectl restart
6. Optionally install monit for monitoring processes and resource utilization