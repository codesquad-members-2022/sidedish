import { SubImg, SubImgWrapper } from './subImgArea.styled';

export function SubImgArea({ urls, onClick }) {
  return (
    <SubImgWrapper>
      {urls.map((url, idx) => (
        <SubImg
          key={`${url}-${idx}`}
          src={url}
          onClick={() => {
            onClick(idx);
          }}
        ></SubImg>
      ))}
      ;
    </SubImgWrapper>
  );
}
