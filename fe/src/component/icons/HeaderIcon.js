import { ReactComponent as CartIcon } from "../../asset/cartIcon.svg";
import { ReactComponent as MyPageIcon } from "../../asset/myPageIcon.svg";
import { ReactComponent as SearchIcon } from "../../asset/searchIcon.svg";
import svgStyles from "../../style/svgStyles";
import styled from "styled-components";

const IconBox = styled.div`
  position: absolute;
  top: 10px;
  right: 80px;
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 100px;
`;

const StyledCartIcon = styled(CartIcon)`
  ${(props) => svgStyles(props)}
`;

const StyledMyPageIcon = styled(MyPageIcon)`
  ${(props) => svgStyles(props)}
`;

const StyledSearchIcon = styled(SearchIcon)`
  ${(props) => svgStyles(props)}
`;

const HeaderIcon = () => {
  return (
    <IconBox>
      <StyledSearchIcon />
      <StyledMyPageIcon />
      <StyledCartIcon />
    </IconBox>
  );
};

export default HeaderIcon;
