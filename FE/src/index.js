import React from "react";
import ReactDOM from "react-dom/client";
<<<<<<< HEAD
<<<<<<< HEAD
import App from "@/App";
=======
import App from "./App";
<<<<<<< HEAD
>>>>>>> ccf5e4b ([#6] Chore: CRA 없이 React 빌드 환경 구축)

=======
=======
import App from "@src/App";
>>>>>>> e0194a0 ([#8] Refactor: import 경로 수정)
window.React = React;
>>>>>>> 3caa9c6 ([#6] Chore: sass 모듈 추가, react 인식 불가 에러 해결)
const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
