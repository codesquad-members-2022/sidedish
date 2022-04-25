import {goodsData} from 'data';
import {Slider} from 'components';
import './SideDishContentsList.css';

function SideDishContentsList() {
  return goodsData.map(element => (
    <li key={element.id}>
      <h3 className="sideDishCategory">{element.title}</h3>
      <Slider data={element.goods} />
    </li>
  ));
}
export {SideDishContentsList};
