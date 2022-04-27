import ReactDOM from 'react-dom';

const Portal = ({ children, wrapperId }) => {
  const wrapperEl = document.getElementById(wrapperId);
  return ReactDOM.createPortal(children, wrapperEl);
};

export default Portal;
