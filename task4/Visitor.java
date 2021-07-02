class Visitor{
    private long timeIn;
    private long timeOut;

    public Visitor(long in, long out){
        this.timeIn = in;
        this.timeOut = out;
    }

    public long getIn(){
        return timeIn;
    }
    public long getOut(){
        return timeOut;
    }
}