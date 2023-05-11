
package TH_LTHDT_Bai2;

public class CD {
    private int maCD, soBaiHat;
    private String tuaCD;
    private double giaThanh;

    public CD() {
    }
    
    public CD(int maCD, int soBaiHat, String tuaCD, double giaThanh) {
        if(maCD>0||maCD!=999999){
            this.maCD=maCD;
        }else{
            this.maCD=999999;
        }
        
        if(soBaiHat>0){
            this.soBaiHat = soBaiHat;
        }else{
            this.soBaiHat = 0;
        }
        
        if(tuaCD.isEmpty()){
            this.tuaCD = "Chua xac dinh";
        }else{
            this.tuaCD = tuaCD;
        }
        
        if(giaThanh>0){
            this.giaThanh = giaThanh;
        }else{
            this.giaThanh = 0;
        }
    }

    public int getMaCD() {
        return maCD;
    }

    public void setMaCD(int maCD) {
        if(maCD>0||maCD!=999999){
            this.maCD=maCD;
        }else{
            this.maCD=999999;
        }
    }

    public int getSoBaiHat() {
        return soBaiHat;
    }

    public void setSoBaiHat(int soBaiHat) {
        if(soBaiHat>0){
            this.soBaiHat = soBaiHat;
        }else{
            this.soBaiHat = 0;
        }
    }

    public String getTuaCD() {
        return tuaCD;
    }

    public void setTuaCD(String tuaCD) {
        if(tuaCD.isEmpty()){
            this.tuaCD = "Chua xac dinh";
        }else{
            this.tuaCD = tuaCD;
        }
    }

    public double getGiaThanh() {
        return giaThanh;
    }

    public void setGiaThanh(double giaThanh) {
        if(giaThanh>0){
            this.giaThanh = giaThanh;
        }else{
            this.giaThanh = 0;
        }
    }

    @Override
    public String toString() {
        return "CD{" + "maCD=" + maCD + ", soBaiHat=" + soBaiHat + ", tuaCD=" + tuaCD + ", giaThanh=" + giaThanh + '}';
    }
}

package TH_LTHDT_Bai2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DSCD {
    ArrayList<CD> cdn = new ArrayList<>();
    
    public void themCD(CD cd){
        if(cdn.size()>=10){
            System.out.println("Khong the them vi mang da day 10 phan tu");
            return;
        }
        for (CD c : cdn) {
            if(c.getMaCD()==cd.getMaCD()){
                System.out.println("Ma CD da trung");
                return;
            }
        }
        cdn.add(cd);
    }
    public int soluong(){
        return cdn.size();
    }
    public double tinhtonggiaCD(){
        double tonggiaCD = 0;
        for (CD c : cdn) {
            tonggiaCD += c.getGiaThanh();
        }
        return tonggiaCD;
    }
    public void sap_xep_gia_giam() {
        Collections.sort(cdn, new Comparator<CD>() {
            @Override
            public int compare(CD cd1, CD cd2) {
                if (cd1.getGiaThanh()> cd2.getGiaThanh()) {
                    return -1;
                } else if (cd1.getGiaThanh()< cd2.getGiaThanh()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }    
    public void sapXepTangDanTheoTuaCD() {
        Collections.sort(cdn, new Comparator<CD>() {
            @Override
            public int compare(CD cd1, CD cd2) {
                return cd1.getTuaCD().compareTo(cd2.getTuaCD());
            }
        });
    }
    
    public void inthongtin(){
        for (CD c : cdn) {
            System.out.println(c.toString());
        }
    }
}
package TH_LTHDT_Bai2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DSCD ds = new DSCD();
        Scanner sc = new Scanner(System.in);
        int menu;
        do{
            System.out.println("-------");
            System.out.println("Chon menu");
            System.out.println("1.them");
            System.out.println("2.tinh so luong ");
            System.out.println("3.tong gia thanh");
            System.out.println("4.sap xep theo gia thanh giam");
            System.out.println("5.sap xep theo tua CD tang");
            System.out.println("6.in thong tin");
            System.out.println("0.thoat");
            System.out.print("Nhap: ");
            menu = sc.nextInt();
            
            switch(menu){
                case 1:
                    System.out.println("Nhap vao ma");
                    int maCD = sc.nextInt();
                    System.out.println("Nhap vao so bai hat");
                    int soBaiHat = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nhap vao tua CD");
                    String tuaCD = sc.nextLine();
                    System.out.println("Nhap vao gia thanh");
                    double giaThanh = sc.nextDouble();
                    CD cd = new CD(maCD, soBaiHat, tuaCD, giaThanh);
                    ds.themCD(cd);
                    break;
                case 2:
                    int soluong=ds.soluong();
                    System.out.println("So luong la "+ soluong);
                    break;
                case 3:
                    double tinhtong = ds.tinhtonggiaCD();
                    System.out.println("tong la "+tinhtong);
                    break;
                case 4:
                    ds.sap_xep_gia_giam();
                    ds.inthongtin();
                    break;
                case 5:
                    ds.sapXepTangDanTheoTuaCD();
                    ds.inthongtin();
                    break;
                case 6:
                    ds.inthongtin();
                    break;
                default:
                if (menu == 0) {
                    System.out.println("Thoat chuong trinh");
                } else {
                    System.out.println("Vui long nhap lai lua chon");
                }
            }
        }while(menu!=0);
    }
}
