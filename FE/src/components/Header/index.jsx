import axios from "axios";
import { API_SERVER_URL } from "constants";
import {
  Cart,
  CategoryTab,
  Container,
  Login,
  Logo,
  Nav,
  NavContent,
  NavIcons,
  Search,
  SubTab,
  SubTabList,
  Tab,
} from "./style";

const HEADER_DATA = [
  {
    id: 100,
    name: "든든한 메인 요리",
    subCategory: [
      { id: 101, name: "육류 요리" },
      { id: 102, name: "해산물 요리" },
    ],
  },
  {
    id: 200,
    name: "뜨끈한 국물요리",
    subCategory: [{ id: 202, name: "국/탕/찌개" }],
  },
  {
    id: 300,
    name: "정갈한 밑반찬",
    subCategory: [
      { id: 301, name: "나물/무침" },
      { id: 302, name: "조림/볶음" },
      { id: 303, name: "절임/장아찌" },
    ],
  },
];

const Header = () => {
  // OAuth Login Form
  // 서버 테스트용
  const requestOAuthLogin = () => {
    axios
      .get(API_SERVER_URL + "/api/login")
      .then(console.log)
      .catch(console.log);
  };
  const requestLogout = () => {
    axios
      .get(API_SERVER_URL + "/api/logout")
      .then(console.log)
      .catch(console.log);
  };

  return (
    <Container>
      <Nav>
        <NavContent>
          <Logo />
          <CategoryTab>
            {HEADER_DATA.map(({ id, name: titleName, subCategory }) => (
              <Tab key={id}>
                <h2>{titleName}</h2>
                <SubTabList>
                  {subCategory.map(({ id, name: subTitleName }) => (
                    <SubTab key={id}>{subTitleName}</SubTab>
                  ))}
                </SubTabList>
              </Tab>
            ))}
          </CategoryTab>
        </NavContent>
        <NavIcons>
          <div>
            <span>미접속</span>
            <button onClick={requestOAuthLogin}>OAuth 로그인</button>
            <button onClick={requestLogout}>로그아웃</button>
          </div>
          <Search />
          <Login />
          <Cart />
        </NavIcons>
      </Nav>
    </Container>
  );
};

export default Header;
