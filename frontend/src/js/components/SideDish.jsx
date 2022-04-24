import {GoodsBlock} from './GoodsBlock.jsx';

function SideDish({type, data, tabState}) {
  if (type === 'best') data = data.filter(element => element.tab.title === tabState)[0].tab.goods;

  return data.map(element => (
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

export {SideDish};
