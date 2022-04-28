import styled from "styled-components";
import {Slider} from "components";
import {mainCategory} from "data";
import "./SideDishContentsList.css";

const SideDishCategory = styled.h3`
  font-weight: 500;
  font-size: 24px;
  margin-bottom: 40px;
`;

function SideDishContentsList({openModal, showAllCategory}) {
  return mainCategory.map(({title, subTitle}, index) => (
    <li key={index}>
      {(showAllCategory || index === 0) && (
        <>
          <SideDishCategory>{subTitle}</SideDishCategory>
          <Slider sideDishTitle={title} openModal={openModal} />
        </>
      )}
    </li>
  ));
}

export {SideDishContentsList};
