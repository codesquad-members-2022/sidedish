/* eslint-disable jsx-a11y/no-noninteractive-tabindex */
/* eslint-disable jsx-a11y/no-static-element-interactions */
import React, { useState } from 'react';
import Sidedish from 'Sidedish';
import { ThemeProvider } from 'styled-components';
import Template from 'template/Template';
import theme from 'variable/theme';

export default function App() {
  const [isTemplateMode, setTemplateMode] = useState(false);
  function handleKeyDown(e) {
    if (e.key === '`') {
      setTemplateMode(!isTemplateMode);
    }
  }
  return (
    <ThemeProvider theme={theme}>
      <div tabIndex="0" className="App" onKeyDown={e => handleKeyDown(e)}>
        {isTemplateMode ? <Template /> : <Sidedish />}
      </div>
    </ThemeProvider>
  );
}
