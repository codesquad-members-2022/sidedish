import {goodsData} from '../data/goods.js';
import {Slider} from './Slider.jsx';
import '../../css/SideDishContentsList.css';

function SideDishContentsList() {
  return goodsData.map(element => (
    <li key={element.id}>
      <h3 className="sideDishCategory">{element.title}</h3>
      <Slider data={element.goods} />
    </li>
  ));
}
export {SideDishContentsList};
