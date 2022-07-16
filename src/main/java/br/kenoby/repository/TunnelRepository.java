package br.kenoby.repository;

import br.kenoby.models.Tunnel;
import java.util.UUID;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

@Primary
public interface TunnelRepository extends JpaRepository<Tunnel, UUID> {
}