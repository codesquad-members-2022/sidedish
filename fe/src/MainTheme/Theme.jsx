import styled from 'styled-components';
import ThemeTab from './ThemeTab';

const Theme = styled.div`
  margin-top: 56px;
`;

const TitleBlock = styled.div`
  padding: 0 80px;
  display: flex;
  align-items: center;

  p {
    margin-right: 16px;
    padding: 8px 16px;
    border: 2px solid #1b1b1b;
    border-radius: 20px;
    font-size: 16px;
    line-height: 26px;
    color: #1b1b1b;
  }

  h1 {
    font-weight: 700;
    font-size: 40px;
    line-height: 58px;
    letter-spacing: -0.004em;
    color: #1b1b1b;
  }
`;

const MainTheme = () => {
  return (
    <Theme>
      <TitleBlock className="theme__title">
        <p>기획전</p>
        <h1>한 번 주문하면 두 번 반하는 반찬</h1>
      </TitleBlock>
      <ThemeTab></ThemeTab>
    </Theme>
  );
};

export default MainTheme;
