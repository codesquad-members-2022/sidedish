import { useContext, useState } from "react";
import DetailInfoContext from "Component/DetailPage/DetailInfoContext";
import constants from "common/constants";
import { ImagesDiv, MainImage, SubImagesArea, SubImage } from "./Images.styled";

const Images = () => {
  const [imageNumber, setImageNumber] = useState(0);
  const { imageFiles, name } = useContext(DetailInfoContext);
  const imageFilesSrc = imageFiles.map((imageFile, idx) => {
    return { src: `${constants.API}/${imageFile}`, idx };
  });

  const handleSubImageClick = ({ target: { id } }) => {
    setImageNumber(Number(id));
  };

  const subImages = imageFilesSrc.map(({ src, idx }) => {
    return (
      <SubImage
        onClick={handleSubImageClick}
        src={src}
        key={idx}
        id={idx}
        imageNumber={imageNumber}
        alt={name}
      />
    );
  });

  return (
    <ImagesDiv>
      <MainImage src={`${imageFilesSrc[imageNumber].src}`} alt={name} />
      <SubImagesArea id={imageNumber}>{subImages}</SubImagesArea>
    </ImagesDiv>
  );
};

export default Images;
