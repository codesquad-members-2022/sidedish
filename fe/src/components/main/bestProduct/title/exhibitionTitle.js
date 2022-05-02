import { Title } from './exhibitionTitle.styled';

export function ExhibitionTitle({ title }) {
  if (!title) {
    return;
  }
  return <Title>{title}</Title>;
}
