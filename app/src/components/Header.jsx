import styled from "styled-components";

const GNBTEXTS = [
  { gnb: "든든한 메인요리", lnb: ["육류 요리", "해산물 요리"] },
  { gnb: "뜨근한 국물요리", lnb: ["국/탕/찌개"] },
  { gnb: "정갈한 밑반찬", lnb: ["나물/무침", "조림/볶음", "절임/장아찌"] },
];

const ICONTEXTS = [
  { name: "search", src: "/images/Search.svg", alt: "검색" },
  { name: "my-page", src: "/images/MyPage.svg", alt: "마이페이지" },
  { name: "card", src: "/images/Cart.svg", alt: "장바구니" },
];

const Header = () => {
  return (
    <HeaderContainer>
      <HeaderContent>
        <Logo>
          <a href="#">Ordering</a>
        </Logo>
        <GNB />
        <IconMenu />
      </HeaderContent>
    </HeaderContainer>
  );
};

const GNB = () => {
  return (
    <Gnb>
      <ul className="gnb">
        {GNBTEXTS.map((e) => (
          <>
            <li className="gnb-item">
              <span>
                <a href="#">{e.gnb}</a>
                <ul className="lnb">
                  {e.lnb.map((el) => (
                    <>
                      <li className="lnb-item">
                        <a href="#">{el}</a>
                      </li>
                    </>
                  ))}
                </ul>
              </span>
            </li>
          </>
        ))}
      </ul>
    </Gnb>
  );
};

const IconMenu = () => {
  return (
    <Icons>
      {ICONTEXTS.map((e) => (
        <>
          <li className={e.name}>
            <a href="#">
              <img src={`${process.env.PUBLIC_URL}${e.src}`} alt={e.alt} />
            </a>
          </li>
        </>
      ))}
    </Icons>
  );
};

const Logo = styled.h1`
  font-family: "Outfit";
  font-size: ${({ theme }) => theme.fontSize.display};
  font-weight: ${({ theme }) => theme.fontWeight.logo};
  margin-left: 8rem;
  margin-right: 4rem;
  line-height: 5rem;
`;

const Gnb = styled.nav`
  .gnb {
    display: flex;
    justify-content: space-between;
    margin-top: 1.2rem;
    width: 35.2rem;
  }

  .gnb:hover {
    margin-bottom: 4.1rem;
  }

  .gnb:hover .lnb {
    display: block;
  }

  .gnb-item {
    font-size: ${({ theme }) => theme.fontSize.medium};
    font-weight: ${({ theme }) => theme.fontWeight.regular};
    line-height: 2.6rem;
  }

  .lnb {
    display: none;
    font-size: ${({ theme }) => theme.fontSize.small};
    margin-top: 1.6rem;
  }

  .lnb-item {
    margin-top: 0.8rem;
  }
`;

const HeaderContainer = styled.div`
  max-height: 19rem;
  min-height: 8.3rem;
  border-bottom: 1px solid ${({ theme }) => theme.color.black};
`;

const HeaderContent = styled.div`
  box-sizing: border-box;
  display: flex;
  margin: 0 auto;
  padding-top: 1.6rem;
  width: 144rem;
`;

const Icons = styled.ul`
  display: flex;
  margin: 1.2rem 8.5rem 0 auto;
  gap: 2.6rem;
  height: 2.8rem;
  align-items: center;
`;

export default Header;
