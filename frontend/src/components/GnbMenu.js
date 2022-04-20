import styled from "styled-components";
const List = styled.li``;

export const GnbMenu = ({ cats, title, show }) => {
  return (
    <List>
      <span>{title}</span>
      {show && cats.map((cat) => <span>${cat}</span>)}
    </List>
  );
};
