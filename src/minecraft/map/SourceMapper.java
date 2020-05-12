package minecraft.map;

import java.io.File;
import java.io.IOException;

import minecraft.ConvertingReport;
import minecraft.Position;
import periphery.SourceGame;
import vmfWriter.Solid;
import vmfWriter.entity.pointEntity.PointEntity;
import vmfWriter.entity.solidEntity.SolidEntity;

public abstract class SourceMapper implements MinecraftMap, SourceMap {

	protected ExtendedSourceMap target;

	public SourceMapper() {
	}

	public SourceMapper setTarget(ExtendedSourceMap target) {
		this.target = target;
		return this;
	}

	@Override
	public void setSkyTexture(String skyTexture) {
		this.target.setSkyTexture(skyTexture);
	}

	@Override
	public void addSolid(Solid shape) {
		this.target.addSolid(shape);
	}

	@Override
	public void addDetail(Solid... solids) {
		this.target.addDetail(solids);
	}

	@Override
	public PointEntity addPointEntity(PointEntity position) {
		return this.target.addPointEntity(position);
	}

	@Override
	public PointEntity addPointEntity(PointEntity entity, Position position) {
		return this.target.addPointEntity(entity, position);
	}

	@Override
	public void addPointEntity(Position origin, PointEntity type) {
		this.target.addPointEntity(origin, type);
	}

	@Override
	public void addSolidEntity(SolidEntity solidEnttiy) {
		this.target.addSolidEntity(solidEnttiy);
	}

	@Override
	public void setCameraPosition(Position origin) {
		this.target.setCameraPosition(origin);
	}

	@Override
	public void setCameraLook(Position position) {
		this.target.setCameraLook(position);
	}

	@Override
	public ConvertingReport write(File file, SourceGame game) throws IOException {
		this.prepareWrite(game);
		this.target.write(file, game);
		return null;
	}

	public abstract ConvertingReport prepareWrite(SourceGame game);
}
