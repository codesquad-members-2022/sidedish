import {MyPage, Search, Shopping_cart} from "../styles/global";
import styled, {css} from "styled-components";
import {Logo} from "../styles/global";
import {useEffect, useState} from "react";
import {GnbList} from "./GnbList";

const HeaderWrap = styled.header`
  ${({theme}) => {
    return css`
      ${theme.custom_absolute(20, null, null, 20)}
      ${theme.width_height_bypx(1440, 83)}
    `
  }}
  border-bottom: 1px solid ${({theme}) => theme.colors.Black}
  background: ${({theme}) => theme.colors.White};
`

const HeaderLogo = styled.span`
  ${({theme}) => {
    return css`
      ${theme.custom_absolute(16, null, null, 80)}
      ${theme.width_height_bypx(174, 50)}
    `
  }}
  ${Logo};
`
const GNB = styled.div`
  ${({theme}) => {
    return css`
      ${theme.custom_flex(`row`, `flex-start`, `center`)}
      ${theme.custom_absolute(28, null, 294)}
    `
  }}

  padding: 0px;

  li {
    left: ${({index}) => index * 130}px;
    
    ${({theme, index}) => {
      return css`
        ${theme.custom_flex('column', 'flex-start')}
        ${theme.custom_static(0)}
        ${theme.flex_none(index, 0, 24)}
      `
    }}
    padding: 0px;
    width: auto;
    height: 26px;
  }
`
const Icon = styled.div`
  ${({theme}) => {
    return css`
      ${theme.custom_flex('row', 'flex-start')}
      ${theme.custom_absolute(128, null, null, 1231)}
      height: 32px;
    `
  }}
`

export const Header = () => {
    const [menus, setMenus] = useState([])
    const [show, setShow] = useState(false);
    useEffect(() => {

    })
    return (
        <HeaderWrap>
            <HeaderLogo></HeaderLogo>
            <GNB onMouseEnter={() => setShow(true)} onMouseleave={() => setShow(false)}>
                {menus.map(menu => <GnbList cats={menu.cats} show={show}></GnbList>)}
            </GNB>
            <Icon>
                <Search></Search>
                <MyPage></MyPage>
                <Shopping_cart></Shopping_cart>
            </Icon>
        </HeaderWrap>
    )

}