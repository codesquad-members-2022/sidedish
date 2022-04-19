import styled from 'styled-components';

const Logo = styled.div`
  font-weight: 900;
  font-size: 40px;
  margin-right: 40px;
  cursor: pointer;
`;

export default function HeaderLogo({ text }) {
  return <Logo>{text}</Logo>;
}
