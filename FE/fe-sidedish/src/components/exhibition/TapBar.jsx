import { TapBarContainer } from "./Exhibition.style";
import TapButton from "./TabButton";

const TapBar = () => {
  return (
    <TapBarContainer>
      <li>
        <TapButton isActive={true} title={"풍성한 고기 반찬"} />
      </li>
      <li>
        <TapButton isActive={false} title={"편리한 반찬 세트"} />
      </li>
      <li>
        <TapButton isActive={false} title={"맛있는 제철 요리"} />
      </li>
      <li>
        <TapButton isActive={false} title={"우리 아이 영양 반찬"} />
      </li>
    </TapBarContainer>
  );
};

export default TapBar;
