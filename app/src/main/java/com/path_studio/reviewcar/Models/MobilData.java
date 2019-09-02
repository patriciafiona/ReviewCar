package com.path_studio.reviewcar.Models;

import java.util.ArrayList;

public class MobilData {

    public static String[][] data = new String[][]{
            {"Toyota Avanza",
                    "1.3E MT",
                    "Rp 191,1 Juta",
                    "https://ik.imagekit.io/hj8sm3kk7/large/gallery/exterior/38/1654/toyota-avanza-2019-front-angle-low-view-187784.jpg",
                    "1329 cc", "91 hp", "120 Nm", "Bensin",
                    "7 Kursi", "45 L", "4190 mm", "1660 mm", "1695 mm", "5 pintu",
                    "1.3 L Petrol Engine, 4 Cylinder 16 Valve, Dual VVT-i "
            },
            {"Daihatsu Grand Xenia",
                    "1.3 X MT",
                    "Rp 186,65 Juta",
                    "https://ik.imagekit.io/hj8sm3kk7/large/gallery/exterior/7/2040/daihatsu-grand-xenia-front-angle-low-view-843120.jpg",
                    "1329 cc", "96 hp", "121 Nm", "Bensin",
                    "7 Kursi", "45 L", "4190 mm", "1660 mm", "1695 mm", "5 pintu",
                    "1.3L Petrol Engine, 4 Cylinder 16 Valve DOHC Dual VVT-i "
            },
            {"Honda Mobilio",
                    "S MT",
                    "Rp 194 Juta",
                    "https://ik.imagekit.io/hj8sm3kk7/large/gallery/exterior/14/98/honda-mobilio-front-angle-low-view-835646.jpg",
                    "1496 cc","116 hp", "145Nm", "Bensin",
                    "6 Kursi", "42 L", "4386 mm", "1683 mm", "1603 mm", "5 Pintu",
                    "1.5 L SOHC silinder segaris, 16 katup i-VTEC + DBW"
            },
            {"Toyota Yaris",
                    "E Grade M/T",
                    "Rp 238,35 Juta",
                    "https://ik.imagekit.io/hj8sm3kk7/large/gallery/exterior/38/1924/toyota-yaris-front-angle-low-view-508123.jpg",
                    "1496 cc","106 hp", "140Nm", "Bensin",
                    "5 Kursi", "42 L", "4145 mm", "1730 mm", "1500 mm", "4 Pintu",
                    "In-line 4 Cyl, 16 Valve, DOHC, Dual VVT-i"
            },
            {"Toyota Kijang Innova",
                    "G M/T Gasoline",
                    "Rp 312,05 Juta",
                    "https://ik.imagekit.io/hj8sm3kk7/large/gallery/exterior/38/1240/toyota-kijang-innova-front-angle-low-view-799776.jpg",
                    "1998 cc","137 hp", "190Nm", "Bensin",
                    "7 Kursi","55 L", "4735 mm", "1830 mm", "1795 mm", "5 Pintu",
                    " 2.0 liter 1TR-FE VVT-i dan 2.7 liter 2TR-FE VVT-i"
            },
            {"Daihatsu Ayla",
                    "1.0L D MT",
                    "Rp 98,15 Juta",
                    "https://ik.imagekit.io/hj8sm3kk7/large/gallery/exterior/7/1731/daihatsu-ayla-front-angle-low-view-264839.jpg",
                    "998 cc","64 hp", "86Nm", "Bensin",
                    "5 Kursi", "33 L", "3640 mm", "1600 mm", "1520 mm", "5 Pintu",
                    "1.200 cc tipe Dual VVT-i "
            },
            {"Toyota Calya",
                    "E MT",
                    "Rp 138,85 Juta",
                    "https://ik.imagekit.io/hj8sm3kk7/large/gallery/exterior/38/1545/toyota-calya-front-angle-low-view-706867.jpg",
                    "1197 cc","87 hp", "108Nm", "Bensin",
                    "7 Kursi", "36 L", "4070 mm", "1655 mm", "1600 mm", "5 Pintu",
                    "Dual VVT-I kapasitas 1.197 cc"
            },
            {"Toyota Fortuner",
                    "2.4 G MT",
                    "Rp 476,05 Juta",
                    "https://ik.imagekit.io/hj8sm3kk7/large/gallery/exterior/38/894/toyota-fortuner-front-angle-low-view-677202.jpg",
                    "2393 cc", "148 hp", "400 Nm", "Diesel",
                    "7 Kursi", "80 L", "4795 mm", "1855 mm", "1835 mm", "5 Pintu",
                    "2.4L Diesel Engine, Inline 4 Cylinder 16 Valve DOHC"
            },
            {"Mitsubishi Xpander",
                    "GLX M/T",
                    "Rp 215,05 Juta",
                    "https://ik.imagekit.io/hj8sm3kk7/large/gallery/exterior/28/1635/mitsubishi-xpander-front-angle-low-view-526896.jpg",
                    "1499 cc", "103 hp", "141 Nm", "Bensin",
                    "7 Kursi", "45 L", "4475 mm", "1750 mm", "1695 mm","5 Pintu",
                    "1,5 L 4A91"
            },
            {"Mitsubishi Pajero Sport ",
                    "Exceed 4x2 MT",
                    "Rp 486,5 Juta",
                    "https://ik.imagekit.io/hj8sm3kk7/large/gallery/exterior/28/899/mitsubishi-pajero-sport-front-angle-low-view-112362.jpg",
                    "2477 cc", "134 hp", "324 Nm", "Diesel",
                    "7 Kursi", "68 L", "4785 mm", "1815 mm", "1805 mm", "5 Pintu",
                    "DOHC 2.5 liter 5 silinder kapasitas 2.500 cc"
            },
            {"Daihatsu Sigra",
                    "1.0 D MT",
                    "Rp 114 Juta",
                    "https://ik.imagekit.io/hj8sm3kk7/large/gallery/exterior/7/1549/daihatsu-sigra-front-angle-low-view-285089.jpg",
                    "998 cc", "66 hp", "89 Nm", "Bensin",
                    "7 Kursi", "36 L", "4070 mm", "1655 mm", "1600 mm", "5 Pintu",
                    "1L 3-silinder"
            },
            {"Daihatsu Terios",
                    "X M/T",
                    "Rp 202,3 Juta",
                    "https://ik.imagekit.io/hj8sm3kk7/large/gallery/exterior/7/1669/daihatsu-terios-front-angle-low-view-795372.jpg",
                    "1496 cc", "103 hp", "136 Nm", "Bensin",
                    "7 Kursi", "45 L", "4435 mm", "1695 mm", "1705 mm ", "5 Pintu",
                    "3SZ-VE 1.495 cc DOHC 16 Valve VVT-i "
            },
            {"Daihatsu Sirion",
                    "1.3L MT",
                    "Rp 187,1 Juta",
                    "https://ik.imagekit.io/hj8sm3kk7/large/gallery/exterior/7/1898/daihatsu-sirion-front-angle-low-view-786013.jpg",
                    "1329 cc", "94 hp", "120 Nm", "Bensin",
                    "5 Kursi", "36 L", "3895 mm ", "1735 mm ", "1525 mm ", "5 Pintu",
                    "K3-VE 1.300cc dengan VVT-i"
            },
            {"Mitsubishi Outlander Sport",
                    "GLX",
                    "Rp 336 Juta",
                    "https://ik.imagekit.io/hj8sm3kk7/large/gallery/exterior/28/364/mitsubishi-outlander-sport-front-angle-low-view-408849.jpg",
                    "1998 cc", "148 hp", "197 Nm", "Bensin",
                    "5 Kursi", "63 L", "4300 mm", "1800 mm", "1625 mm","5 Pintu",
                    "4B11, 16valve, MIVEC, DOHC"
            },
    };

    public static ArrayList<Mobil> getListData(){
        ArrayList<Mobil> list = new ArrayList<>();
        for (String[] aData : data) {
            Mobil mobil = new Mobil();
            mobil.setMerk_mobil(aData[0]);
            mobil.setTipe_mobil(aData[1]);
            mobil.setRange_harga(aData[2]);
            mobil.setPhoto(aData[3]);
            list.add(mobil);
        }
        return list;
    }

    //keperluan filter
    public static ArrayList<Mobil> getFilterText(String text){
        ArrayList<Mobil> filterList = new ArrayList<>();
        //proses filter dari arraylist
        for (String[] bData : data) {
            if ((bData[0]).toLowerCase().contains(text.toLowerCase())) {
                Mobil mobil = new Mobil();
                mobil.setMerk_mobil(bData[0]);
                mobil.setTipe_mobil(bData[1]);
                mobil.setRange_harga(bData[2]);
                mobil.setPhoto(bData[3]);
                filterList.add(mobil);
            }

        }
        return filterList;
    }

    //mendapatkan data sesuai dengan posisi list yang dipilih
    public static ArrayList<Mobil> getDetailData(int posisi){
        ArrayList<Mobil> filterList = new ArrayList<>();

        Mobil mobil = new Mobil();
        mobil.setMerk_mobil(data[posisi][0]);
        mobil.setTipe_mobil(data[posisi][1]);
        mobil.setRange_harga(data[posisi][2]);
        mobil.setPhoto(data[posisi][3]);

        mobil.setKapasitas_mesin(data[posisi][4]);
        mobil.setTenaga_mesin(data[posisi][5]);
        mobil.setTorsi(data[posisi][6]);
        mobil.setJenis_bbm(data[posisi][7]);

        mobil.setTempat_duduk(data[posisi][8]);
        mobil.setTangki(data[posisi][9]);
        mobil.setPanjang(data[posisi][10]);
        mobil.setLebar(data[posisi][11]);
        mobil.setTinggi(data[posisi][12]);
        mobil.setJumlah_pintu(data[posisi][13]);
        mobil.setMesin(data[posisi][14]);

        filterList.add(mobil);

        return filterList;
    }

}
