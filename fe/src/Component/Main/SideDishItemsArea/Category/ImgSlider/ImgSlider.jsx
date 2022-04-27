import Card from "Component/Card/Card";
import PropTypes from "prop-types";
import { ImgSliderUl, Wrapper } from "./ImgSlider.styled";

const Cards = ({ datas }) => {
  return datas.map((data) => (
    <Card key={data.id} props={data} className="card" type="small" />
  ));
};

const ImgSlider = ({ sideDishes, sliderRef }) => {
  return (
    <Wrapper>
      <ImgSliderUl ref={sliderRef}>
        <Cards datas={sideDishes} />
      </ImgSliderUl>
    </Wrapper>
  );
};
ImgSlider.propTypes = {
  sideDishes: PropTypes.arrayOf(
    PropTypes.objectOf(
      PropTypes.oneOfType([PropTypes.number, PropTypes.string, PropTypes.bool])
    )
  ).isRequired,
  sliderRef: PropTypes.oneOfType([
    PropTypes.func,
    PropTypes.shape({ current: PropTypes.instanceOf(Element) }),
  ]).isRequired,
};

export default ImgSlider;
