import {goodsData} from '../data/goods.js';
import {GoodsBlock} from './GoodsBlock.jsx';

function BestSideDish({tabState}) {
  return goodsData
    .filter(element => element.tab.title === tabState)[0]
    .tab.goods.map(element => (
      <li key={element.id}>
        <GoodsBlock
          thumb={element.thumb}
          name={element.name}
          description={element.description}
          price={element.price}
          label={element.label}
        />
      </li>
    ));
}

export {BestSideDish};
