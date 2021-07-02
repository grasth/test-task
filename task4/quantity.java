class Quantity extends Visitor{
    public Quantity(long in, long out) {
        super(in, out);
    }

    private int visitorCount;
    private long firstVisitorIn;
    private long lastVisitorOut;

    public void setVisitorCount(int count){
        this.visitorCount = count;
    }

    public void setVisitorsData(long _firstVisitorIn, long _lastVisitorOut){
        this.firstVisitorIn = _firstVisitorIn;
        this.lastVisitorOut = _lastVisitorOut;
    }

    public long getFirstVisitorIn(){
        return firstVisitorIn;
    }

    public long getLastVisitorOut(){
        return lastVisitorOut;
    }

    public int getVisitorCount(){
        return visitorCount;
    }
    public long getIn(){
        return super.getIn();
    }
    public long getOut(){
        return super.getOut();
    }
}
