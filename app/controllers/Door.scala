package controllers

import play.api.Play
import play.api.Play.current
import play.api.mvc._
import com.pi4j.io.gpio._
import com.pi4j.io.gpio.impl.PinImpl
import java.util.EnumSet

object Door extends Controller {
  val gpio: GpioController = GpioFactory.getInstance()

  def open(id: Int) = Action {
    val gpioPin = getGPIOPin(id)

    gpioPin.high()
    Thread sleep 1000
    gpioPin.low()

    Ok("{\"success\": \"true\"}")
  }

  def getGPIOPin(id: Int): GpioPinDigitalOutput  = {
    val address = Play.configuration.getInt("door."+id+".pin").getOrElse(17)
    val pin = new PinImpl(RaspiGpioProvider.NAME, address, "GPIO "+address, EnumSet.of(PinMode.DIGITAL_OUTPUT), PinPullResistance.all())
    gpio.provisionDigitalOutputPin(pin, "Door"+id, PinState.LOW)
  }
}