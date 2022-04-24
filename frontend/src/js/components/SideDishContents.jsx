import {SideDishContentsList} from './SideDishContentsList.jsx';
import '../../css/SideDishContents.css';

function SideDishContents() {
  return (
    <div className="sideDishContents">
      <ul>
        <SideDishContentsList />
      </ul>
    </div>
  );
}

export {SideDishContents};
