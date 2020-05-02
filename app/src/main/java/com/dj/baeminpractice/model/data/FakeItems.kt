package com.dj.baeminpractice.model.data

import com.dj.baeminpractice.R
import com.dj.baeminpractice.model.BannerItem
import com.dj.baeminpractice.model.GridItem
import com.dj.baeminpractice.model.WhatToEat

val fakeBannerItemList = listOf(
    BannerItem(R.drawable.first),
    BannerItem(R.drawable.second),
    BannerItem(R.drawable.third),
    BannerItem(R.drawable.fourth),
    BannerItem(R.drawable.fifth)
)

val fakeGridItemList = listOf(
    GridItem(R.drawable.a, "1인분"),
    GridItem(R.drawable.b, "배민오더"),
    GridItem(R.drawable.c, "배민라이더스"),
    GridItem(R.drawable.d, "한식"),
    GridItem(R.drawable.e, "분식"),
    GridItem(R.drawable.f, "카페·디저트"),
    GridItem(R.drawable.g, "돈까스·회·일식"),
    GridItem(R.drawable.h, "치킨"),
    GridItem(R.drawable.i, "피자"),
    GridItem(R.drawable.j, "이시안·양식"),
    GridItem(R.drawable.k, "중국집"),
    GridItem(R.drawable.l, "족발·보쌈"),
    GridItem(R.drawable.m, "야식"),
    GridItem(R.drawable.n, "찜·탕"),
    GridItem(R.drawable.o, "도시락"),
    GridItem(R.drawable.p, "패스트푸드"),
    GridItem(R.drawable.q, "프랜차이즈"),
    GridItem(R.drawable.r, "배민키친"),
    GridItem(R.drawable.s, "맛집랭킹"),
    GridItem(R.drawable.t) //Last Item is Blank
)

// 뭐먹지 리스트용!
val fakeWhatToEatList = listOf(
    WhatToEat("피자피자, 피자 먹자!",
        "https://i.ytimg.com/vi/7p6rcKJNAUg/hqdefault.jpg",
        "피자, 양식, 패스트푸드, 지방"),
    WhatToEat("햄버거, 햄버거 한입?!",
        "https://images2.minutemediacdn.com/image/upload/c_crop,h_1126,w_2000,x_0,y_181/f_auto,q_auto,w_1100/v1554932288/shape/mentalfloss/12531-istock-637790866.jpg", "햄버거, 패티, 양식, 치즈, 패티패티"),
    WhatToEat("스테이크, 미디움 레어로 먹자!",
        "https://i2.wp.com/www.foodrepublic.com/wp-content/uploads/2012/05/testkitchen_argentinesteak.jpg?resize=1280%2C%20560&ssl=1",
        "스테이크, 미디움, 레어, 고기, 마늘, 소고기"),
    WhatToEat("다양하게 골라 먹는 푸드!",
        "https://i0.wp.com/post.healthline.com/wp-content/uploads/2019/05/Various_Sandwiches_1296x728-header-1296x728.jpg?w=1155&h=1528",
        "다양성, 음식묵자, 푸드"),
    WhatToEat("야채야채한 야채를 먹는 베지터블?",
        "https://images.unsplash.com/photo-1498837167922-ddd27525d352?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2850&q=80",
        "베지터블, 야채야채, 먹어보자, 식물")
)