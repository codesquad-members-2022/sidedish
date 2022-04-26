import React, { useCallback, useState } from "react";
import { useEffect } from "react";
import axios from "axios";
import BestMealCard from "components/BestMealCard";
import Loader from "components/Loader";

import { MOCK_SERVER_URL } from "constants";
import { CardContainer, Container, Divider, Header, Li, Nav, Tab, Title, TitleBadge } from "./style";

const BEST_TITLE_BADGE = "기획전";
const BEST_TITLE = "한 번 주문하면 두 번 반하는 반찬";
const BEST_SUBTITLE = [
  { id: 0, title: "풍성한 고기 반찬" },
  { id: 1, title: "편리한 반찬 세트" },
  { id: 2, title: "맛있는 제철 요리" },
  { id: 3, title: "우리 아이 영양 반찬" },
];

const MOCK_DATA_JS = [
  {
    id: 1,
    image: "https://recipe1.ezmember.co.kr/cache/recipe/2015/06/18/5fb9f882810cc18567c01faeb6773ba8.jpg",
    productName: "오리 주물럭 반조리",
    description: "감칠맛 나는 매콤한 양념",
    fixedPrice: 12640,
    originalPrice: 15800,
    event: "런칭특가",
  },
  {
    id: 2,
    image: "https://recipe1.ezmember.co.kr/cache/recipe/2015/06/18/5fb9f882810cc18567c01faeb6773ba8.jpg",
    productName: "잡채",
    description: "탱글한 면과 맛깔진 고명이 가득",
    fixedPrice: 11610,
    originalPrice: 12900,
    event: "이벤트특가",
  },
  {
    id: 3,
    image: "https://recipe1.ezmember.co.kr/cache/recipe/2015/06/18/5fb9f882810cc18567c01faeb6773ba8.jpg",
    productName: "소갈비찜",
    description: "촉촉하게 밴 양념이 일품",
    fixedPrice: 26010,
    originalPrice: 28900,
    event: "이벤트특가",
  },
  {
    id: 4,
    image:
      "https://s3-alpha-sig.figma.com/img/33bc/7060/2cdf7235b65a114abff05b9133f90085?Expires=1651449600&Signature=GkIDXNQYgylWHG6s0156N~naar2gkF38JhOATAhWKeeHbRT-kL2ijeaFLLZOKSD73FeHAN9qEVDVseXH4fvzR~936Jydsw4S8W7DsU4IBU48TMJdv~VpUo9~W-OHQu68L~rB5n3ol0VvEX1eJAzJqmotiVC1GSRtcpwjzg4DpUKkhnmfDs7j0lP9a7ggNSZdyCxs85cOYFqSwPAOOK~CeL~iO8a9kvq24BzQIlHkIwBVZ4cZQy43TAj4S-Cy3Nu8ck6NVmyi9HHIdKpWzxN0E6sTTPtmgsvoItVvpqpK9DbkaTMwdxj16-AraqhH36l0zqFeKBJslCXkq-9XXIxJAw__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA",
    productName: "간장 코다리조림",
    description: "쫀득한 코다리를 국내산 간장소스로맛있게 조렸어요",
    fixedPrice: 14900,
    originalPrice: 14900,
    event: "",
  },
];

const BestMealContainer = () => {
  const [meals, setMeals] = useState([]);
  const [tab, setTab] = useState(0);

  const fetchData = useCallback(async () => {
    try {
      // const { response } = await axios.get(`${MOCK_SERVER_URL}/api/products/best?category=${tab}`, {
      //   validateStatus: (status) => {
      //     return status >= 200 && status < 300;
      //   },
      // });
      // const meal = response;
      const meal = MOCK_DATA_JS;
      setMeals(meal);
    } catch (error) {
      console.error(error);
    }
  }, [tab]);

  useEffect(() => {
    fetchData();
  }, []);

  const BestMealCards = () => meals.map(({ id, ...meal }) => <BestMealCard key={id} meal={meal} />);

  const Tabs = ({ id, title }) => (
    <Tab key={id} onClick={() => setTab(id)} isSelected={tab === id}>
      {title}
    </Tab>
  );

  return (
    <Container>
      <Header>
        <div>{BEST_TITLE_BADGE}</div>
        <h2>{BEST_TITLE}</h2>
      </Header>
      <Nav>
        {BEST_SUBTITLE.map(({ id, title }) => (
          <Tabs id={id} title={title} />
        ))}
      </Nav>
      <Divider />
      <CardContainer>{meals.length ? <BestMealCards /> : <Loader />}</CardContainer>
    </Container>
  );
};

export default BestMealContainer;
