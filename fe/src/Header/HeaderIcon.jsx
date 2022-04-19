import styled from 'styled-components';

const Icon = styled.img`
  width: 100%;
  cursor: pointer;
  margin: 12.5px;
`;

export default function HeaderIcon({ path }) {
  return <Icon src={path}></Icon>;
}
