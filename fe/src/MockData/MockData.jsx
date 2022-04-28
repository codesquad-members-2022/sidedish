const MenuDatas = [
  {
    id: 0,
    name: "든든한 메인요리",
    subMenu: [
      { id: 0, name: "육류요리" },
      { id: 1, name: "해산물요리" },
    ],
  },
  { id: 1, name: "뜨끈한 국물요리", subMenu: [{ id: 0, name: "국/탕/찌개" }] },
  {
    id: 2,
    name: "정갈한 밑반찬",
    subMenu: [
      { id: 0, name: "나물/무침" },
      { id: 1, name: "조림/볶음" },
      { id: 2, name: "절임/장아찌" },
    ],
  },
];
const icons = [
  {
    id: 0,
    svg: (
      <svg
        width="24"
        height="24"
        viewBox="0 0 24 24"
        fill="none"
        xmlns="http://www.w3.org/2000/svg"
      >
        <path
          d="M16.6667 14.6667H15.6133L15.24 14.3067C16.5918 12.7387 17.3348 10.7369 17.3333 8.66667C17.3333 6.95256 16.825 5.27695 15.8727 3.85172C14.9204 2.4265 13.5669 1.31567 11.9833 0.659711C10.3996 0.00375132 8.65706 -0.167878 6.97589 0.166528C5.29472 0.500933 3.75047 1.32635 2.53841 2.53841C1.32636 3.75046 0.500937 5.29471 0.166531 6.97588C-0.167874 8.65705 0.00375513 10.3996 0.659715 11.9833C1.31567 13.5669 2.4265 14.9204 3.85173 15.8727C5.27695 16.825 6.95257 17.3333 8.66667 17.3333C10.8133 17.3333 12.7867 16.5467 14.3067 15.24L14.6667 15.6133V16.6667L21.3333 23.32L23.32 21.3333L16.6667 14.6667V14.6667ZM8.66667 14.6667C5.34667 14.6667 2.66667 11.9867 2.66667 8.66667C2.66667 5.34667 5.34667 2.66667 8.66667 2.66667C11.9867 2.66667 14.6667 5.34667 14.6667 8.66667C14.6667 11.9867 11.9867 14.6667 8.66667 14.6667Z"
          fill="#1B1B1B"
        />
      </svg>
    ),
  },
  {
    id: 1,
    login: true,
    svg: (
      <svg
        width="22"
        height="22"
        viewBox="0 0 22 22"
        fill="#1B1B1B"
        xmlns="http://www.w3.org/2000/svg"
      >
        <path
          d="M11 11C13.9467 11 16.3334 8.61333 16.3334 5.66667C16.3334 2.72 13.9467 0.333334 11 0.333334C8.05337 0.333334 5.66671 2.72 5.66671 5.66667C5.66671 8.61333 8.05337 11 11 11ZM11 13.6667C7.44004 13.6667 0.333374 15.4533 0.333374 19V21.6667H21.6667V19C21.6667 15.4533 14.56 13.6667 11 13.6667Z"
          fill="null"
        />
      </svg>
    ),
  },
  {
    id: 2,
    svg: (
      <svg
        width="27"
        height="28"
        viewBox="0 0 27 28"
        fill="null"
        xmlns="http://www.w3.org/2000/svg"
      >
        <path
          d="M8.33337 22C6.86671 22 5.68004 23.2 5.68004 24.6667C5.68004 26.1333 6.86671 27.3333 8.33337 27.3333C9.80004 27.3333 11 26.1333 11 24.6667C11 23.2 9.80004 22 8.33337 22ZM0.333374 0.666666V3.33333H3.00004L7.80004 13.4533L6.00004 16.72C5.78671 17.0933 5.66671 17.5333 5.66671 18C5.66671 19.4667 6.86671 20.6667 8.33337 20.6667H24.3334V18H8.89337C8.70671 18 8.56004 17.8533 8.56004 17.6667L8.60004 17.5067L9.80004 15.3333H19.7334C20.7334 15.3333 21.6134 14.7867 22.0667 13.96L26.84 5.30667C26.95 5.10318 27.0054 4.87464 27.0007 4.64337C26.996 4.4121 26.9313 4.18601 26.8131 3.98718C26.6949 3.78836 26.5271 3.6236 26.3262 3.50899C26.1252 3.39439 25.898 3.33387 25.6667 3.33333H5.94671L4.69337 0.666666H0.333374ZM21.6667 22C20.2 22 19.0134 23.2 19.0134 24.6667C19.0134 26.1333 20.2 27.3333 21.6667 27.3333C23.1334 27.3333 24.3334 26.1333 24.3334 24.6667C24.3334 23.2 23.1334 22 21.6667 22Z"
          fill="#1B1B1B"
        />
      </svg>
    ),
  },
];
const githubIcon = {
  id: 3,
  svg: (
    <svg
      width="27"
      height="28"
      role="img"
      viewBox="0 0 24 24"
      xmlns="http://www.w3.org/2000/svg"
    >
      <path d="M12 .297c-6.63 0-12 5.373-12 12 0 5.303 3.438 9.8 8.205 11.385.6.113.82-.258.82-.577 0-.285-.01-1.04-.015-2.04-3.338.724-4.042-1.61-4.042-1.61C4.422 18.07 3.633 17.7 3.633 17.7c-1.087-.744.084-.729.084-.729 1.205.084 1.838 1.236 1.838 1.236 1.07 1.835 2.809 1.305 3.495.998.108-.776.417-1.305.76-1.605-2.665-.3-5.466-1.332-5.466-5.93 0-1.31.465-2.38 1.235-3.22-.135-.303-.54-1.523.105-3.176 0 0 1.005-.322 3.3 1.23.96-.267 1.98-.399 3-.405 1.02.006 2.04.138 3 .405 2.28-1.552 3.285-1.23 3.285-1.23.645 1.653.24 2.873.12 3.176.765.84 1.23 1.91 1.23 3.22 0 4.61-2.805 5.625-5.475 5.92.42.36.81 1.096.81 2.22 0 1.606-.015 2.896-.015 3.286 0 .315.21.69.825.57C20.565 22.092 24 17.592 24 12.297c0-6.627-5.373-12-12-12" />
    </svg>
  ),
};
const event = {
  eventName: "한 번 주문하면 두 번 반하는 반찬",
  eventCategories: [
    {
      id: 1,
      name: "풍성한 고기 반찬",
    },
    {
      id: 2,
      name: "편리한 반찬 세트",
    },
    {
      id: 3,
      name: "맛있는 제철 요리",
    },
    {
      id: 4,
      name: "우리 아이 영양 반찬",
    },
  ],
};
const categoryMenus = {
  sideDishes: [
    {
      id: 1,
      name: "오리 주물럭_반조리",
      description: "감칠맛 나는 매콤한 양념",
      dawnDeliveryFlag: true,
      wholeNationDeliveryFlag: true,
      price: 15800,
      discountType: "런칭특가",
      discountRate: 20,
      saveFileName: "img/1_ma_1.png",
    },
    {
      id: 2,
      name: "소갈비찜",
      description: "촉촉하게 벤 양념이 일품",
      dawnDeliveryFlag: true,
      wholeNationDeliveryFlag: false,
      price: 28900,
      discountType: "이벤트특가",
      discountRate: 10,
      saveFileName: "img/2_ma_1.png",
    },
    {
      id: 4,
      name: "돼지불갈비",
      description: "맛있어요!!",
      dawnDeliveryFlag: false,
      wholeNationDeliveryFlag: true,
      price: 10000,
      discountType: null,
      discountRate: 0,
      saveFileName: "img/4_ma_1.png",
    },
  ],
};
const categoryFirstData = {
  menuCategories: [
    {
      menuCategoryName: "식탁을 풍성하게 하는 정갈한 밑반찬",
      sideDishes: [
        {
          id: 1,
          name: "오리 주물럭_반조리",
          description: "감칠맛 나는 매콤한 양념",
          dawnDeliveryFlag: true,
          wholeNationDeliveryFlag: true,
          price: 15800,
          discountType: "런칭특가",
          discountRate: 20,
          saveFileName: "img/1_ma_1.png",
        },
        {
          id: 2,
          name: "오리 주물럭_반조리",
          description: "감칠맛 나는 매콤한 양념",
          dawnDeliveryFlag: true,
          wholeNationDeliveryFlag: true,
          price: 15800,
          discountType: "런칭특가",
          discountRate: 20,
          saveFileName: "img/1_ma_1.png",
        },
        {
          id: 3,
          name: "오리 주물럭_반조리",
          description: "감칠맛 나는 매콤한 양념",
          dawnDeliveryFlag: true,
          wholeNationDeliveryFlag: true,
          price: 15800,
          discountType: "런칭특가",
          discountRate: 20,
          saveFileName: "img/1_ma_1.png",
        },
        {
          id: 4,
          name: "오리 주물럭_반조리",
          description: "감칠맛 나는 매콤한 양념",
          dawnDeliveryFlag: true,
          wholeNationDeliveryFlag: true,
          price: 15800,
          discountType: "런칭특가",
          discountRate: 20,
          saveFileName: "img/1_ma_1.png",
        },
        {
          id: 5,
          name: "오리 주물럭_반조리",
          description: "감칠맛 나는 매콤한 양념",
          dawnDeliveryFlag: true,
          wholeNationDeliveryFlag: true,
          price: 15800,
          discountType: "런칭특가",
          discountRate: 20,
          saveFileName: "img/1_ma_1.png",
        },
        {
          id: 6,
          name: "오리 주물럭_반조리",
          description: "감칠맛 나는 매콤한 양념",
          dawnDeliveryFlag: true,
          wholeNationDeliveryFlag: true,
          price: 15800,
          discountType: "런칭특가",
          discountRate: 20,
          saveFileName: "img/1_ma_1.png",
        },
      ],
    },
  ],
};
const categoryRestData = {
  menuCategories: [
    {
      menuCategoryName: "정성이 담긴 뜨끈뜨근 국물 요리",
      sideDishes: [
        {
          id: 9,
          name: "냉면",
          description: "맛있어요!!",
          dawnDeliveryFlag: true,
          wholeNationDeliveryFlag: true,
          price: 8000,
          discountType: "이벤트 특가",
          discountRate: 20,
          saveFileName: "img/9_ma_1.png",
        },
      ],
    },
    {
      menuCategoryName: "모두가 좋아하는 든든한 메인 요리",
      sideDishes: [
        {
          id: 1,
          name: "오리 주물럭_반조리",
          description: "감칠맛 나는 매콤한 양념",
          dawnDeliveryFlag: true,
          wholeNationDeliveryFlag: true,
          price: 15800,
          discountType: "이벤트 특가",
          discountRate: 20,
          saveFileName: "img/1_ma_1.png",
        },
        {
          id: 2,
          name: "소갈비찜",
          description: "촉촉하게 벤 양념이 일품",
          dawnDeliveryFlag: false,
          wholeNationDeliveryFlag: false,
          price: 28900,
          discountType: "런칭 특가",
          discountRate: 10,
          saveFileName: "img/2_ma_1.png",
        },
        {
          id: 3,
          name: "쭈꾸미 한돈 제육볶음_반조리",
          description: "쫄깃한 쭈구미와 고소한 돼지고기가 일품",
          dawnDeliveryFlag: false,
          wholeNationDeliveryFlag: false,
          price: 16900,
          discountType: null,
          discountRate: 0,
          saveFileName: "img/3_ma_1.png",
        },
        {
          id: 4,
          name: "돼지불갈비",
          description: "맛있어요!!",
          dawnDeliveryFlag: false,
          wholeNationDeliveryFlag: false,
          price: 10000,
          discountType: null,
          discountRate: 0,
          saveFileName: "img/4_ma_1.png",
        },
        {
          id: 11,
          name: "연어구이",
          description: "맛있어요!!",
          dawnDeliveryFlag: false,
          wholeNationDeliveryFlag: false,
          price: 10000,
          discountType: null,
          discountRate: 0,
          saveFileName: "img/11_ma_1.png",
        },
        {
          id: 12,
          name: "광어구이",
          description: "맛있어요!!",
          dawnDeliveryFlag: false,
          wholeNationDeliveryFlag: false,
          price: 11000,
          discountType: null,
          discountRate: 0,
          saveFileName: "img/12_ma_1.png",
        },
        {
          id: 20,
          name: "소갈비찜",
          description: "촉촉하게 벤 양념이 일품",
          dawnDeliveryFlag: false,
          wholeNationDeliveryFlag: false,
          price: 28900,
          discountType: "런칭 특가",
          discountRate: 10,
          saveFileName: "img/2_ma_1.png",
        },
        {
          id: 31,
          name: "쭈꾸미 한돈 제육볶음_반조리",
          description: "쫄깃한 쭈구미와 고소한 돼지고기가 일품",
          dawnDeliveryFlag: false,
          wholeNationDeliveryFlag: false,
          price: 16900,
          discountType: null,
          discountRate: 0,
          saveFileName: "img/3_ma_1.png",
        },
        {
          id: 42,
          name: "돼지불갈비",
          description: "맛있어요!!",
          dawnDeliveryFlag: false,
          wholeNationDeliveryFlag: false,
          price: 10000,
          discountType: null,
          discountRate: 0,
          saveFileName: "img/4_ma_1.png",
        },
        {
          id: 50,
          name: "연어구이",
          description: "맛있어요!!",
          dawnDeliveryFlag: false,
          wholeNationDeliveryFlag: false,
          price: 10000,
          discountType: null,
          discountRate: 0,
          saveFileName: "img/11_ma_1.png",
        },
        {
          id: 51,
          name: "광어구이",
          description: "맛있어요!!",
          dawnDeliveryFlag: false,
          wholeNationDeliveryFlag: false,
          price: 11000,
          discountType: null,
          discountRate: 0,
          saveFileName: "img/12_ma_1.png",
        },
      ],
    },
  ],
};
const ImgSliderButtons = {
  left: (
    <svg
      width="11"
      height="20"
      viewBox="0 0 11 20"
      fill="none"
      xmlns="http://www.w3.org/2000/svg"
    >
      <path
        d="M9 18L1 10L9 2"
        strokeWidth="2"
        strokeLinecap="square"
        strokeLinejoin="round"
      />
    </svg>
  ),
  right: (
    <svg
      width="11"
      height="20"
      viewBox="0 0 11 20"
      fill="none"
      xmlns="http://www.w3.org/2000/svg"
    >
      <path
        d="M2 18L10 10L2 2"
        strokeWidth="2"
        strokeLinecap="square"
        strokeLinejoin="round"
      />
    </svg>
  ),
};
const plusMinusButtons = {
  plus: (
    <svg
      width="32"
      height="32"
      viewBox="0 0 32 32"
      fill="none"
      xmlns="http://www.w3.org/2000/svg"
    >
      <path
        d="M16 9V23"
        stroke="#1B1B1B"
        strokeWidth="2"
        strokeLinecap="square"
        strokeLinejoin="round"
      />
      <path
        d="M9 16H23"
        stroke="#1B1B1B"
        strokeWidth="2"
        strokeLinecap="square"
        strokeLinejoin="round"
      />
    </svg>
  ),
  minus: (
    <svg
      width="16"
      height="9"
      viewBox="0 0 16 2"
      fill="none"
      xmlns="http://www.w3.org/2000/svg"
    >
      <path
        d="M1 1H15"
        stroke="#1B1B1B"
        strokeWidth="2"
        strokeLinecap="square"
        strokeLinejoin="round"
      />
    </svg>
  ),
};
export {
  MenuDatas,
  icons,
  event,
  categoryMenus,
  categoryFirstData,
  categoryRestData,
  ImgSliderButtons,
  plusMinusButtons,
  githubIcon,
};
