import {Slider} from "components";
import {mainCategory} from "data";
import "./SideDishContentsList.css";

function SideDishContentsList({openModal, showAllCategory}) {
  return mainCategory.map(({title, subTitle}, index) => (
    <li key={index}>
      {(showAllCategory || index === 0) && (
        <>
          <h3 className="sideDishCategory">{subTitle}</h3>
          <Slider sideDishTitle={title} openModal={openModal} />
        </>
      )}
    </li>
  ));
}

export {SideDishContentsList};
