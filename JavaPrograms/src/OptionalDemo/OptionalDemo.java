package OptionalDemo;

import java.util.ArrayList;
import java.util.Optional;

class Computer1 {
    private Optional<Soundcard1> soundcard;

    public Optional<Soundcard1> getSoundcard1() {
        return soundcard;
    }

    public void setSoundcard1(Optional<Soundcard1> soundcard) {
        this.soundcard = soundcard;
    }
}

class Soundcard1
{
    private Optional<USB1> usb;

    public Optional<USB1> getUsb() {
        return usb;
    }

    public void setUsb(Optional<USB1> usb) {
        this.usb = usb;
    }
}

class USB1
{

    public String Version;

    USB1(String version)
    {
        this.Version = version;
    }



    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }
}

public class OptionalDemo {

    public static void main(String args[]) {
        Soundcard1 soundcard = new Soundcard1();
        USB1 usb = new USB1("1.2");

        Optional<Soundcard1> sc = Optional.of(soundcard);
        Optional<USB1> usbs  = Optional.of(usb);

        if(sc.isPresent()&& usbs.isPresent())
        {
          System.out.println(sc.get().getUsb().get().getVersion());
        }

    }












}
