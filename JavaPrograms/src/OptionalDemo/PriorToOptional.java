package OptionalDemo;

 class Computer {
    private Soundcard soundcard;

    Computer(Soundcard s)
    {
        this.soundcard = s;
    }

    public Soundcard getSoundcard() {
        return soundcard;
    }

    public void setSoundcard(Soundcard soundcard) {
        this.soundcard = soundcard;
    }
}

class Soundcard
{
    private USB usb;
    Soundcard (USB u)
    {
        this.usb = u;
    }


    public USB getUsb() {
        return usb;
    }

    public void setUsb(USB usb) {
        this.usb = usb;
    }
}

class USB
{

    public String Version;

    USB(String version)
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

public class PriorToOptional
{
    public static void main(String args[]) {
        Computer c = new Computer(new Soundcard(new USB("1.2")));


        if(c!=null)
        {
            if(!c.getSoundcard().equals(null))
            {
                if(!c.getSoundcard().getUsb().equals(null))
                {
                    c.getSoundcard().getUsb().getVersion();
                }
            }
        }

    }

}