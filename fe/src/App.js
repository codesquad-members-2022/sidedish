import Reset from "./Reset";
import Normalize from "./Normalize";
import Header from "./Component/Header/Header";
import Main from "./Component/Main/Main";

const App = () => {
	return (
		<div className="App">
			<Reset />
			<Normalize />
			<Header />
			<Main />
		</div>
	);
};

export default App;
