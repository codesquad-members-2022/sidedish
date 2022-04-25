import { Title } from './BestProduct.styled';

export function ExhibitionTitle({ title }) {
  if (!title) {
    return;
  }
  return <Title>{title}</Title>;
}
