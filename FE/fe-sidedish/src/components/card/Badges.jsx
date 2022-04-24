import { Badge, BadgeContainer } from './Card.style';

const Badges = ({ badges }) => {
  return (
    <BadgeContainer>
      {badges.map((badge, index) => <Badge key={index} type={`${badge}`}>{badge}</Badge>)}
    </BadgeContainer>
  )
}

export default Badges;
