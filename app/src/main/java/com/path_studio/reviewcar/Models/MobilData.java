package com.path_studio.reviewcar.Models;

import java.util.ArrayList;

public class MobilData {

    public static String[][] data = new String[][]{
            {"Toyota Avanza",
                    "1.3E MT",
                    "Rp 191,1 Juta",
                    "https://ik.imagekit.io/hj8sm3kk7/large/gallery/exterior/38/1654/toyota-avanza-2019-front-angle-low-view-187784.jpg"
            },
            {"Daihatsu Grand Xenia",
                    "1.3 X MT",
                    "Rp 186,65 Juta",
                    "https://ik.imagekit.io/hj8sm3kk7/large/gallery/exterior/7/2040/daihatsu-grand-xenia-front-angle-low-view-843120.jpg"
            },
            {"Honda Mobilio",
                    "S MT",
                    "Rp 194 Juta",
                    "https://ik.imagekit.io/hj8sm3kk7/large/gallery/exterior/14/98/honda-mobilio-front-angle-low-view-835646.jpg"
            },
            {"Toyota Yaris",
                    "E Grade M/T",
                    "Rp 238,35 Juta",
                    "https://ik.imagekit.io/hj8sm3kk7/large/gallery/exterior/38/1924/toyota-yaris-front-angle-low-view-508123.jpg"
            },
            {"Toyota Kijang Inova",
                    "G M/T Gasoline",
                    "Rp 312,05 Juta",
                    "https://ik.imagekit.io/hj8sm3kk7/large/gallery/exterior/38/1240/toyota-kijang-innova-front-angle-low-view-799776.jpg"
            },
            {"Daihatsu Alya",
                    "1.0L D MT",
                    "Rp 98,15 Juta",
                    "https://ik.imagekit.io/hj8sm3kk7/large/gallery/exterior/7/1731/daihatsu-ayla-front-angle-low-view-264839.jpg"
            },
            {"Toyota Calya",
                    "E MT",
                    "Rp 138,85 Juta",
                    "https://ik.imagekit.io/hj8sm3kk7/large/gallery/exterior/38/1545/toyota-calya-front-angle-low-view-706867.jpg"
            },
            {"Toyota Fortuner",
                    "2.4 G MT",
                    "Rp 476,05 Juta",
                    "https://ik.imagekit.io/hj8sm3kk7/large/gallery/exterior/38/894/toyota-fortuner-front-angle-low-view-677202.jpg"
            },
            {"Mitsubishi Xpander",
                    "GLX M/T",
                    "Rp 215,05 Juta",
                    "https://ik.imagekit.io/hj8sm3kk7/large/gallery/exterior/28/1635/mitsubishi-xpander-front-angle-low-view-526896.jpg"
            },
            {"Mitsubishi Pajero Sport ",
                    "Exceed 4x2 MT",
                    "Rp 486,5 Juta",
                    "https://ik.imagekit.io/hj8sm3kk7/large/gallery/exterior/28/899/mitsubishi-pajero-sport-front-angle-low-view-112362.jpg"
            },
            {"Daihatsu Sigra",
                    "1.0 D MT",
                    "Rp 114 Juta",
                    "https://ik.imagekit.io/hj8sm3kk7/large/gallery/exterior/7/1549/daihatsu-sigra-front-angle-low-view-285089.jpg"
            },
            {"Daihatsu Terios",
                    "X M/T",
                    "Rp 202,3 Juta",
                    "https://ik.imagekit.io/hj8sm3kk7/large/gallery/exterior/7/1669/daihatsu-terios-front-angle-low-view-795372.jpg"
            },
            {"Daihatsu Sirion",
                    "1.3L MT",
                    "Rp 187,1 Juta",
                    "https://ik.imagekit.io/hj8sm3kk7/large/gallery/exterior/7/1898/daihatsu-sirion-front-angle-low-view-786013.jpg"
            },
            {"Mitsubishi Outlander Sport",
                    "GLX",
                    "Rp 336 Juta",
                    "https://ik.imagekit.io/hj8sm3kk7/large/gallery/exterior/28/364/mitsubishi-outlander-sport-front-angle-low-view-408849.jpg"
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

}
