// The purpose of this class is to model a television
// Your name and today's date
public class Television {
    
    private final String MANUFACTURER;
    private final int SCREEN_SIZE;
    
    private boolean powerOn;
    private int channel;
    private int volume;

    public Television(String brand, int size) {
        this.MANUFACTURER = brand;
        this.SCREEN_SIZE = size;
        this.powerOn = false;
        this.volume = 20;
        this.channel = 2;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public void power() {
        this.powerOn = !powerOn;
    }

    public void increaseVolume() {
        this.volume++;
    }

    public void decreaseVolume() {
        this.volume--;
    }

    public int getChannel() {
        return channel;
    }

    public int getVolume() {
        return volume;
    }

    public String getManufacturer() {
        return MANUFACTURER;
    }

    public int getScreenSize() {
        return SCREEN_SIZE;
    }
}
