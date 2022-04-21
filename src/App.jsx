/* eslint-disable jsx-a11y/no-noninteractive-tabindex */
/* eslint-disable jsx-a11y/no-static-element-interactions */
import React, { useState } from "react";
import Sidedish from "./Sidedish";
import Template from "./template/Template";

export default function App() {
  const [isTemplateMode, toggleTemplateMode] = useState(true);
  function handleKeyDown(e) {
    if (e.key === "`") {
      toggleTemplateMode(!isTemplateMode);
    }
  }
  return (
    <div tabIndex="0" className="App" onKeyDown={(e) => handleKeyDown(e)}>
      {isTemplateMode ? <Template /> : <Sidedish />}
    </div>
  );
}
