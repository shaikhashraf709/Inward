package com.ashraf.inward;

public class Inward_Model {

    String name ,pic;


    public Inward_Model() {
    }

    public Inward_Model(String name, String pic) {
        this.name = name;
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return "https://1.bp.blogspot.com/-As2LicKAAw4/YFd92z49lSI/AAAAAAAAAus/" +
                "9CGh58Th2oEdfcTlRftpHoVeKUhoZsF7wCLcBGAsYHQ/s0/Placeholder.png";
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
