import React from "react";
import ReactDOM from "react-dom/client";
<<<<<<< HEAD
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
<<<<<<< HEAD
>>>>>>> e0194a0 ([#8] Refactor: import 경로 수정)
window.React = React;
>>>>>>> 3caa9c6 ([#6] Chore: sass 모듈 추가, react 인식 불가 에러 해결)
=======
=======
import App from "@/App";
>>>>>>> 82dc859 (Chore: config의 절대경로 alias 수정)

>>>>>>> b3671d9 ([#6] Chore: babel config에 `runtime: automatic' 추가)
const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
