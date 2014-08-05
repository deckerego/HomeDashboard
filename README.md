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
    <td>Raspberry Pi NoIR Camera (or a spare Video4Linux-compliant webcam)</td>
    <td>https://www.sparkfun.com/products/12654</td>
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

1. Install Sun's Java Development Kit for ARM from http://www.oracle.com/technetwork/java/javase/downloads/index.html
2. Install the GarageSecurity Debian package
3. Install the Apache2 site "security" from config/etc/apache2/sites-available/security
4. Re-start Apache2 via sudo apachectl restart