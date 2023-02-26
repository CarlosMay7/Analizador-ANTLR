// Generated from Arit.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AritParser}.
 */
public interface AritListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AritParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(AritParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link AritParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(AritParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link AritParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(AritParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link AritParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(AritParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link AritParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(AritParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link AritParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(AritParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link AritParser#valor}.
	 * @param ctx the parse tree
	 */
	void enterValor(AritParser.ValorContext ctx);
	/**
	 * Exit a parse tree produced by {@link AritParser#valor}.
	 * @param ctx the parse tree
	 */
	void exitValor(AritParser.ValorContext ctx);
	/**
	 * Enter a parse tree produced by {@link AritParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(AritParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link AritParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(AritParser.FactorContext ctx);
}