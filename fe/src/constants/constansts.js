const GNBLists = [
  { navTitle: "든든한 메인 요리", navList: ["육류 요리", "해산물 요리"] },
  { navTitle: "뜨끈한 국물요리", navList: ["국/탕/찌개"] },
  {
    navTitle: "정갈한 밑반찬",
    navList: ["나물/무침", "조림/볶음", "절임/장아찌"],
  },
];

const MAIN_API_URL = "http://15.165.204.34:8080/api/v1/products/";

const tapInforList = [
  {
    id: 0,
    title: "우리 아이 영양 반찬",
    postfix: "반찬/영양",
  },
  {
    id: 1,
    title: "편리한 반찬세트",
    postfix: "반찬/편리",
  },
  {
    id: 2,
    title: "맛있는 제철요리",
    postfix: "반찬/제철",
  },
  {
    id: 3,
    title: "풍성한 고기반찬",
    postfix: "반찬/고기",
  },
];

const CardSize = {
  small: 320,
  big: 420,
};

const SlideINfor = [
  {
    id: 0,
    title: "든든한 메인요리",
    postfix: "메인",
  },
  {
    id: 1,
    title: "정갈한 밑반찬",
    postfix: "반찬",
  },
  {
    id: 2,
    title: "뜨끈한 국물요리",
    postfix: "국물",
  },
];

const constansts = {
  GNBLists,
  tapInforList,
  CardSize,
  SlideINfor,
  MAIN_API_URL,
};

export default constansts;
