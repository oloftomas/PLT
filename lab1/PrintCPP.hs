{-# OPTIONS_GHC -fno-warn-incomplete-patterns #-}
module PrintCPP where

-- pretty-printer generated by the BNF converter

import AbsCPP
import Data.Char


-- the top-level printing method
printTree :: Print a => a -> String
printTree = render . prt 0

type Doc = [ShowS] -> [ShowS]

doc :: ShowS -> Doc
doc = (:)

render :: Doc -> String
render d = rend 0 (map ($ "") $ d []) "" where
  rend i ss = case ss of
    "["      :ts -> showChar '[' . rend i ts
    "("      :ts -> showChar '(' . rend i ts
    "{"      :ts -> showChar '{' . new (i+1) . rend (i+1) ts
    "}" : ";":ts -> new (i-1) . space "}" . showChar ';' . new (i-1) . rend (i-1) ts
    "}"      :ts -> new (i-1) . showChar '}' . new (i-1) . rend (i-1) ts
    ";"      :ts -> showChar ';' . new i . rend i ts
    t  : ts@(p:_) | closingOrPunctuation p -> showString t . rend i ts
    t        :ts -> space t . rend i ts
    _            -> id
  new i   = showChar '\n' . replicateS (2*i) (showChar ' ') . dropWhile isSpace
  space t = showString t . (\s -> if null s then "" else ' ':s)
  closingOrPunctuation [c] = c `elem` ")],;"
  closingOrPunctuation _   = False

parenth :: Doc -> Doc
parenth ss = doc (showChar '(') . ss . doc (showChar ')')

concatS :: [ShowS] -> ShowS
concatS = foldr (.) id

concatD :: [Doc] -> Doc
concatD = foldr (.) id

replicateS :: Int -> ShowS -> ShowS
replicateS n f = concatS (replicate n f)

-- the printer class does the job
class Print a where
  prt :: Int -> a -> Doc
  prtList :: Int -> [a] -> Doc
  prtList i = concatD . map (prt i)

instance Print a => Print [a] where
  prt = prtList

instance Print Char where
  prt _ s = doc (showChar '\'' . mkEsc '\'' s . showChar '\'')
  prtList _ s = doc (showChar '"' . concatS (map (mkEsc '"') s) . showChar '"')

mkEsc :: Char -> Char -> ShowS
mkEsc q s = case s of
  _ | s == q -> showChar '\\' . showChar s
  '\\'-> showString "\\\\"
  '\n' -> showString "\\n"
  '\t' -> showString "\\t"
  _ -> showChar s

prPrec :: Int -> Int -> Doc -> Doc
prPrec i j = if j<i then parenth else id


instance Print Integer where
  prt _ x = doc (shows x)


instance Print Double where
  prt _ x = doc (shows x)



instance Print Id where
  prt _ (Id i) = doc (showString ( i))
  prtList _ [x] = (concatD [prt 0 x])
  prtList _ (x:xs) = (concatD [prt 0 x, doc (showString "::"), prt 0 xs])


instance Print Program where
  prt i e = case e of
    Prog defs -> prPrec i 0 (concatD [prt 0 defs])

instance Print Def where
  prt i e = case e of
    DFun type_ id args stms -> prPrec i 0 (concatD [prt 0 type_, prt 0 id, doc (showString "("), prt 0 args, doc (showString ")"), doc (showString "{"), prt 0 stms, doc (showString "}")])
    QConuse ids -> prPrec i 0 (concatD [doc (showString "using"), prt 0 ids, doc (showString ";")])
  prtList _ [] = (concatD [])
  prtList _ (x:xs) = (concatD [prt 0 x, prt 0 xs])
instance Print Arg where
  prt i e = case e of
    ADecl type_ id -> prPrec i 0 (concatD [prt 0 type_, prt 0 id])
  prtList _ [] = (concatD [])
  prtList _ [x] = (concatD [prt 0 x])
  prtList _ (x:xs) = (concatD [prt 0 x, doc (showString ","), prt 0 xs])
instance Print Stm where
  prt i e = case e of
    SExp exp -> prPrec i 0 (concatD [prt 0 exp, doc (showString ";")])
    SDecl type_ id -> prPrec i 0 (concatD [prt 0 type_, prt 0 id, doc (showString ";")])
    SDecls type_ id ids -> prPrec i 0 (concatD [prt 0 type_, prt 0 id, doc (showString ","), prt 0 ids, doc (showString ";")])
    SInit type_ id exp -> prPrec i 0 (concatD [prt 0 type_, prt 0 id, doc (showString "="), prt 0 exp, doc (showString ";")])
    STypedef ids id -> prPrec i 0 (concatD [doc (showString "typedef"), prt 0 ids, prt 0 id, doc (showString ";")])
    SReturn exp -> prPrec i 0 (concatD [doc (showString "return"), prt 0 exp, doc (showString ";")])
    SWhile exp stm -> prPrec i 0 (concatD [doc (showString "while"), doc (showString "("), prt 0 exp, doc (showString ")"), prt 0 stm])
    SBlock stms -> prPrec i 0 (concatD [doc (showString "{"), prt 0 stms, doc (showString "}")])
    SIfElse exp stm1 stm2 -> prPrec i 0 (concatD [doc (showString "if"), doc (showString "("), prt 0 exp, doc (showString ")"), prt 0 stm1, doc (showString "else"), prt 0 stm2])
  prtList _ [] = (concatD [])
  prtList _ (x:xs) = (concatD [prt 0 x, prt 0 xs])
instance Print Exp where
  prt i e = case e of
    EInt n -> prPrec i 15 (concatD [prt 0 n])
    EString strs -> prPrec i 15 (concatD [prt 0 strs])
    EDouble d -> prPrec i 15 (concatD [prt 0 d])
    EQcon ids -> prPrec i 15 (concatD [prt 0 ids])
    EIndex exp1 exp2 -> prPrec i 14 (concatD [prt 14 exp1, doc (showString "["), prt 0 exp2, doc (showString "]")])
    ECall exp exps -> prPrec i 14 (concatD [prt 14 exp, doc (showString "("), prt 0 exps, doc (showString ")")])
    ECalle exp -> prPrec i 14 (concatD [prt 14 exp, doc (showString "("), doc (showString ")")])
    EDot exp1 exp2 -> prPrec i 13 (concatD [prt 13 exp1, doc (showString "."), prt 14 exp2])
    EArrow exp id -> prPrec i 13 (concatD [prt 13 exp, doc (showString "->"), prt 0 id])
    EInc exp -> prPrec i 13 (concatD [prt 13 exp, doc (showString "++")])
    EDec exp -> prPrec i 13 (concatD [prt 13 exp, doc (showString "--")])
    EPinc exp -> prPrec i 12 (concatD [doc (showString "++"), prt 12 exp])
    EPdec exp -> prPrec i 12 (concatD [doc (showString "--"), prt 12 exp])
    EDeref exp -> prPrec i 12 (concatD [doc (showString "*"), prt 12 exp])
    ENeg exp -> prPrec i 12 (concatD [doc (showString "!"), prt 12 exp])
    EMul exp1 exp2 -> prPrec i 11 (concatD [prt 11 exp1, doc (showString "*"), prt 12 exp2])
    EDiv exp1 exp2 -> prPrec i 11 (concatD [prt 11 exp1, doc (showString "/"), prt 12 exp2])
    EMod exp1 exp2 -> prPrec i 11 (concatD [prt 11 exp1, doc (showString "%"), prt 12 exp2])
    EAdd exp1 exp2 -> prPrec i 10 (concatD [prt 10 exp1, doc (showString "+"), prt 11 exp2])
    ESub exp1 exp2 -> prPrec i 10 (concatD [prt 10 exp1, doc (showString "-"), prt 11 exp2])
    ELShift exp1 exp2 -> prPrec i 9 (concatD [prt 9 exp1, doc (showString "<<"), prt 10 exp2])
    ERShift exp1 exp2 -> prPrec i 9 (concatD [prt 9 exp1, doc (showString ">>"), prt 10 exp2])
    EEq exp1 exp2 -> prPrec i 7 (concatD [prt 7 exp1, doc (showString "=="), prt 8 exp2])
    ENeq exp1 exp2 -> prPrec i 7 (concatD [prt 7 exp1, doc (showString "!="), prt 8 exp2])
    EConj exp1 exp2 -> prPrec i 3 (concatD [prt 3 exp1, doc (showString "&&"), prt 4 exp2])
    EDisj exp1 exp2 -> prPrec i 2 (concatD [prt 2 exp1, doc (showString "||"), prt 3 exp2])
    EAss exp1 exp2 -> prPrec i 1 (concatD [prt 2 exp1, doc (showString "="), prt 1 exp2])
    EAssp exp1 exp2 -> prPrec i 1 (concatD [prt 2 exp1, doc (showString "+="), prt 1 exp2])
    EAssm exp1 exp2 -> prPrec i 1 (concatD [prt 2 exp1, doc (showString "-="), prt 1 exp2])
    ECond exp1 exp2 exp3 -> prPrec i 1 (concatD [prt 2 exp1, doc (showString "?"), prt 0 exp2, doc (showString ":"), prt 1 exp3])
  prtList _ [] = (concatD [])
  prtList _ [x] = (concatD [prt 0 x])
  prtList _ (x:xs) = (concatD [prt 0 x, doc (showString ","), prt 0 xs])
instance Print Type where
  prt i e = case e of
    Tbool -> prPrec i 0 (concatD [doc (showString "bool")])
    Tdouble -> prPrec i 0 (concatD [doc (showString "double")])
    Tint -> prPrec i 0 (concatD [doc (showString "int")])
    Tvoid -> prPrec i 0 (concatD [doc (showString "void")])
    Tid ids -> prPrec i 0 (concatD [prt 0 ids])


