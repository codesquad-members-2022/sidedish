import SubContent from './SubContent';

const SubContents = ({ subContents }) => (
  <>
    {subContents.map((content) => (
      <SubContent key={content.title} content={content} />
    ))}
  </>
);
export default SubContents;
